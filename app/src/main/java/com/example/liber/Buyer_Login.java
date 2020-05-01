package com.example.liber;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Buyer_Login extends AppCompatActivity {

     EditText  bEmail, bPassword;
     TextView forotPassword;
     Button bLogin;
     FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buyer__login);


        bEmail = findViewById(R.id.b_Email);
        bPassword = findViewById(R.id.b_Password);
        bLogin = findViewById(R.id.b_Login);
        forotPassword = findViewById(R.id.frogotPassword);

        mAuth = FirebaseAuth.getInstance();


        bLogin.setOnClickListener(new View.OnClickListener() {
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

                mAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(Buyer_Login.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (!task.isSuccessful()) {
                                    Toast.makeText(Buyer_Login.this, "Logged in Successfully" + task.getException(), Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(Buyer_Login.this, "Error" + task.getException(),
                                            Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }

            });

       bLogin.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               startActivity(new Intent(getApplicationContext(),Buyer_Reg.class));
           }
                });

       forotPassword.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               EditText restMail = new EditText(v.getContext());
               final AlertDialog.Builder passwordResetDialog = new AlertDialog.Builder(v.getContext());
               passwordResetDialog.setTitle("Reset Password?");
               passwordResetDialog.setMessage("Enter your Email To Received Reset Link");
               passwordResetDialog.setView(restMail);

               passwordResetDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialog, int which) {
                       String mail = resetMail.getText().toString();
                       mAuth.sendPasswordResetEmail(mail);addOnSuccessListener(new OnSuccessListener<Void>() {
                           @Override
                           public void onSuccess(Void aVoid) {

                           }
                       });{

                       }
                       @Override
                           public void OnSuccess(Void ){
                               Toast.makeText(Buyer_Login.this,"Reset Link Sent To Your Email",Toast.LENGTH_SHORT).show();
                           });addFailureListener(new OnFailureListener(){
                               @Override
                                public void onFailure(@NonNull Exception e){
                                   Toast.makeText(Buyer_Login.this,"Error Reset Link is Not sent"+e.getMessage() Toast.LENGTH_SHORT).show();)
                               }
                           });
                       }

               });
                passwordResetDialog.setNegativeButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                            public void onClick(DialogInterface dialog, int which){

                       }
                   }
           }
       });
            }

        }
