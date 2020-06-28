package com.example.organdonationapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    MaterialButton btnlogin,btnsignup;
    EditText etmail,etpassword;
    FirebaseAuth auth;
    User users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                init();

                btnsignup.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent object = new Intent(MainActivity.this,Register.class);
                        startActivity(object);
                    }
                });

                btnlogin.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                      String Email=etmail.getText().toString().trim();
                      String password= etpassword.getText().toString().trim();

                      if(Email.isEmpty()||password.isEmpty()){
                          Toast.makeText(MainActivity.this,"Fill all Feilds",Toast.LENGTH_SHORT).show();
                      }
                      else {
                          auth.signInWithEmailAndPassword(Email,password)
                                  .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                      @Override
                                      public void onComplete(@NonNull Task<AuthResult> task) {
                                          if(task.isSuccessful())
                                          {
                                              Intent object = new Intent(MainActivity.this,Home.class);
                                              startActivity(object);

                                          }
                                          else
                                          {
                                              Toast.makeText(MainActivity.this,"Authentication Error",Toast.LENGTH_SHORT).show();
                                          }
                                      }
                                  });
                      }
                    }
                });
            }
        });

    }
    private void init(){
        btnlogin = findViewById(R.id.btnlogin);
        btnsignup = findViewById(R.id.btnsignup);
        etmail = findViewById(R.id.etmail);
        etpassword = findViewById(R.id.etpassword);
        auth=FirebaseAuth.getInstance();

    }
}
