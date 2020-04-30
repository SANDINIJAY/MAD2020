package com.example.liber;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Buyer_Reg extends AppCompatActivity {

     EditText bFname, bLname, bAddress, bEmail, bPassword, bPhone;
     Button bRegister;
     TextView mLoginbtn;
     FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buyer__reg);


        bFname = findViewById(R.id.b_fname);
        bLname = findViewById(R.id.b_lname);
        bAddress = findViewById(R.id.b_add);
        bEmail = findViewById(R.id.b_Email);
        bPassword = findViewById(R.id.b_Password);
        bPhone = findViewById(R.id.e_b_phone);
        bRegister = findViewById(R.id.bSign);
        mLoginbtn = findViewById(R.id.createText);


        mAuth = FirebaseAuth.getInstance();


        if (mAuth.getCurrentUser() != null) {
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            finish();
        }

        bRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = bEmail.getText().toString().trim();
                String password = bPassword.getText().toString().trim();

                if (TextUtils.isEmpty(email)) {
                    bEmail.setError("Email is Requird");
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    bPassword.setError("Password is Requird");
                    return;
                }

                if (password.length() < 6) {
                    bPassword.setError("Password Must be 6 characters");
                    return;
                }
                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(Buyer_Reg.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                Toast.makeText(Buyer_Reg.this, "createUserWithEmail:onComplete:" + task.isSuccessful(), Toast.LENGTH_SHORT).show();

                                if (!task.isSuccessful()) {
                                    Toast.makeText(Buyer_Reg.this, "User Created" + task.getException(),
                                            Toast.LENGTH_SHORT).show();
                                } else {
                                    startActivity(new Intent(Buyer_Reg.this, MainActivity.class));
                                    finish();
                                }
                            }
                        });
            }
        });
    }
}
