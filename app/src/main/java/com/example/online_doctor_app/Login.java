package com.example.online_doctor_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
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
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity {

    EditText login_email, login_password;
    Button btn_signup, btn_login;
    FirebaseAuth mFirebaseAuth;

    private FirebaseAuth.AuthStateListener mAuthStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mFirebaseAuth = FirebaseAuth.getInstance();
        login_email = findViewById(R.id.login_email);
        login_password = findViewById(R.id.login_password);
        btn_signup = findViewById(R.id.btn_signup);
        btn_login = findViewById(R.id.btn_login);

        mAuthStateListener = new FirebaseAuth.AuthStateListener() {
            @SuppressLint("ShowToast")
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {

                FirebaseUser mFirebaseUser = mFirebaseAuth.getCurrentUser();
                if (mFirebaseUser != null)
                {
                    Toast.makeText(Login.this, "YOU ARE LOGGED IN", Toast.LENGTH_SHORT).show();

                    Intent obj = new Intent (Login.this, HomePage.class);
                    startActivity(obj);
                }
                else
                {
                    Toast.makeText(Login.this, "PLEASE LOGIN", Toast.LENGTH_SHORT).show();
                }

            }
        };

        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent obj = new Intent(Login.this, Signup.class);
                startActivity(obj);
            }
        });


        btn_login.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ShowToast")
            @Override
            public void onClick(View view) {

                String email = login_email.getText().toString();
                String password = login_password.getText().toString();

                if (email.isEmpty())
                {
                    login_email.setError("PLEASE ENTER YOUR EMAIL");
                    login_email.requestFocus();
                }

                else if (password.isEmpty())
                {
                    login_password.setError("PLEASE ENTER YOUR PASSWORD");
                    login_password.requestFocus();
                }

                if (email.isEmpty() && password.isEmpty())
                {
                    Toast.makeText(Login.this, "FIELDS ARE EMPTY", Toast.LENGTH_SHORT).show();
                }

                if (!(email.isEmpty() && password.isEmpty()))
                {
                    mFirebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(Login.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if (!task.isSuccessful())
                            {
                                Toast.makeText(Login.this, "LOGIN UNSUCCESSFUL"  + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                            else
                            {
                                Intent obj = new Intent (Login.this, HomePage.class);
                                startActivity(obj);
                            }
                        }
                    });
                }
                else
                {
                    Toast.makeText(Login.this, "ERROR OCCURRED", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        mFirebaseAuth.addAuthStateListener(mAuthStateListener);
    }
}
