package com.example.organdonationapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Register extends AppCompatActivity {

    EditText etname,etmail,etpassword,etaddress,ettype,etorgan,etcontact,etblood;
    MaterialButton btnregister;
    DatabaseReference dbref;
    FirebaseAuth auth;
    User users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        etname=findViewById(R.id.etname);
        etmail=findViewById(R.id.etmail);
        etpassword=findViewById(R.id.etpassword);
        etaddress=findViewById(R.id.etaddress);
        ettype=findViewById(R.id.ettype);
        etblood=findViewById(R.id.etblood);
        etorgan=findViewById(R.id.etorgan);
        etcontact=findViewById(R.id.etcontact);
        btnregister=findViewById(R.id.btnregister);

        auth = FirebaseAuth.getInstance();
        dbref= FirebaseDatabase.getInstance().getReference();


        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name =etname.getText().toString().trim();
                String Email = etmail.getText().toString().trim();
                String password = etpassword.getText().toString().trim();
                String address = etaddress.getText().toString().trim();
                String usertype = ettype.getText().toString().trim();
                String organ = etorgan.getText().toString().trim();
                String blood = etblood.getText().toString().trim();
                String contact = etcontact.getText().toString().trim();
                String id;

                if(Email.isEmpty()||password.isEmpty()||name.isEmpty()||address.isEmpty()||usertype.isEmpty()||organ.isEmpty()||contact.isEmpty())
                {
                    Toast.makeText(Register.this,"please enter data to register",Toast.LENGTH_SHORT).show();
                }
                else
                {

                     id= dbref.push().getKey();
                     User user= new User(name, Email,  password, address, contact,  usertype, organ, blood);
                     dbref.child(id).setValue(user);

                    auth.createUserWithEmailAndPassword(Email,password)
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful())
                            {
                                Toast.makeText(Register.this,"User created successfully",Toast.LENGTH_SHORT).show();
                            }
                            else
                            {
                                Toast.makeText(Register.this,"Error",Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });

    }


}