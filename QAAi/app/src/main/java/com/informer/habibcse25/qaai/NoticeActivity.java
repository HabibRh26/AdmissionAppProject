package com.informer.habibcse25.qaai;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.informer.habibcse25.qaai.Model_clss.NoticeData_to_firebase;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class NoticeActivity extends AppCompatActivity {
    DatabaseReference dbRef;
    TextView txtVwNotice,txtVw_NoticeUniv_Name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice);
        txtVwNotice = findViewById(R.id.txtVw_Notice);
        txtVw_NoticeUniv_Name = findViewById(R.id.txtVw_NoticeUniv_Name);
        dbRef = FirebaseDatabase.getInstance().getReference("Notice");


        dbRef.child("demo").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                NoticeData_to_firebase uni_Name = dataSnapshot.getValue(NoticeData_to_firebase.class);
                NoticeData_to_firebase univ_Notice  = dataSnapshot.getValue(NoticeData_to_firebase.class);

                txtVw_NoticeUniv_Name.setText(uni_Name.getUni_Name());
                txtVwNotice.setText(univ_Notice.getUniv_Notice());

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
}
