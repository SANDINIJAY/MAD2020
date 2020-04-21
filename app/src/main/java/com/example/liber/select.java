package com.example.liber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class select extends AppCompatActivity {
    Button cAcc;
    Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);

        cAcc = (Button) findViewById(R.id.cAcc);
        cAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent in=new Intent(select.this,Buyer_Reg.class);
                startActivity(in);
            }
        });

        login= (Button) findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent in=new Intent(select.this,Buyer_Login.class);
                startActivity(in);
            }
        });

        cAcc = (Button) findViewById(R.id.cAcc);
        cAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent in=new Intent(select.this,seller_regs.class);
                startActivity(in);
            }
        });

        login = (Button) findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent in=new Intent(select.this,Seller_Login.class);
                startActivity(in);
            }
        });
    }
}
