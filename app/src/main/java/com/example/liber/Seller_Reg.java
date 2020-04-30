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

public class Seller_Reg extends AppCompatActivity {

    EditText sName,sAddress,sEmail,sPassword,sPhone;
    Button sRegister;
    FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seller__reg);

        sName = findViewById(R.id.s_name);
        sAddress = findViewById(R.id.s_add);
        sPassword = findViewById(R.id.s_Password);
        sPhone = findViewById(R.id.e_s_phone);



        mAuth = FirebaseAuth.getInstance();

        if (mAuth.getCurrentUser() != null) {
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            finish();
        }

        sRegister.setOnClickListener(new View.OnClickListener() {
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

                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(Seller_Reg.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                Toast.makeText(Seller_Reg.this, "createUserWithEmail:onComplete:" + task.isSuccessful(), Toast.LENGTH_SHORT).show();

                                if (!task.isSuccessful()) {
                                    Toast.makeText(Seller_Reg.this, "User Created" + task.getException(),
                                            Toast.LENGTH_SHORT).show();
                                } else {
                                    startActivity(new Intent(Seller_Reg.this, MainActivity.class));
                                    finish();
                                }
                            }
                        });
            }
        });
    }
}
