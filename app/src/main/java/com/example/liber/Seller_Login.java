package com.example.liber;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Seller_Login extends AppCompatActivity {

    EditText sPassword,sEmail;
    Button sLogin;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seller__login);


        sEmail = findViewById(R.id.s_Email);
        sPassword = findViewById(R.id.s_Password);
        sLogin = findViewById(R.id.s_login);

        mAuth = FirebaseAuth.getInstance();

        sLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = sEmail.getText().toString().trim();
                String password = sPassword.getText().toString().trim();

                if (TextUtils.isEmpty(email)) {
                    sEmail.setError("Email is Requird");
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    sPassword.setError("Password is Requird");
                    return;
                }

                if (password.length() < 6) {
                    sPassword.setError("Password Must be 6 characters");
                    return;
                }

                mAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(Seller_Login.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (!task.isSuccessful()) {
                                    Toast.makeText(Seller_Login.this, "Logged in Successfully" + task.getException(), Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(Seller_Login.this, "Error" + task.getException(),
                                            Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }

        });

                sLogin.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(getApplicationContext(),Buyer_Reg.class));
                    }
                });
            }

        }



