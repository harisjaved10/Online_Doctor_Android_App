package com.example.online_doctor_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Signup extends AppCompatActivity {

    EditText signup_email, signup_password, signup_conpassword;
    Button btn_done;
    FirebaseAuth mFirebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        mFirebaseAuth = FirebaseAuth.getInstance();
        signup_email = findViewById(R.id.signup_email);
        signup_password = findViewById(R.id.signup_password);
        signup_conpassword = findViewById(R.id.signup_conpassword);
        btn_done = findViewById(R.id.btn_done);

        btn_done.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                String email = signup_email.getText().toString();
                String password = signup_password.getText().toString();
                String confirm_password = signup_conpassword.getText().toString();

                if (email.isEmpty()) {
                    signup_email.setError("PLEASE ENTER YOUR EMAIL");
                    signup_email.requestFocus();
                } else if (password.isEmpty()) {
                    signup_password.setError("PLEASE ENTER YOUR PASSWORD");
                    signup_password.requestFocus();
                } else if (confirm_password.isEmpty()) {
                    signup_conpassword.setError("PLEASE CONFIRM YOUR PASSWORD");
                    signup_conpassword.requestFocus();
                }

                if (email.isEmpty() || password.isEmpty() || confirm_password.isEmpty()) {
                    Toast.makeText(Signup.this, "FIELDS ARE EMPTY", Toast.LENGTH_SHORT).show();
                }

                if (!(email.isEmpty() && password.isEmpty() && confirm_password.isEmpty())) {
                    mFirebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(Signup.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if (!task.isSuccessful()) {
                                Toast.makeText(Signup.this, "Signup Unsuccessful" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                            else {
                                Intent obj = new Intent(Signup.this, Login.class);
                                startActivity(obj);
                            }
                        }
                    });
                } else {
                    Toast.makeText(Signup.this, "ERROR OCURRED", Toast.LENGTH_SHORT).show();
                }


            }
        });

    }
}
