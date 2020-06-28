package com.example.organdonationapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

public class Home extends AppCompatActivity {

    Button btnrqst,btnrecipent,btndonor;
    DatabaseReference dbref;
    List<User> users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btnrecipent = findViewById(R.id.btnrecipent);
        btndonor = findViewById(R.id.btndonor);



        final ValueEventListener valueEventListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                users.clear();
                if(dataSnapshot.exists())
                {
                    for(DataSnapshot snapshot : dataSnapshot.getChildren()){
                        User user=snapshot.getValue(User.class);
                        users.add(user);


                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        };

        btnrecipent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbref = FirebaseDatabase.getInstance().getReference("user");

                    Query query = FirebaseDatabase.getInstance().getReference("user")
                            .orderByChild("usertype")
                            .equalTo("Reciepent");
                    dbref.addListenerForSingleValueEvent(valueEventListener);
            }
        });

        btndonor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbref = FirebaseDatabase.getInstance().getReference("user");

                Query query = FirebaseDatabase.getInstance().getReference("user")
                        .orderByChild("usertype")
                        .equalTo("Donor");

                dbref.addListenerForSingleValueEvent(valueEventListener);

            }
        });





    }
}