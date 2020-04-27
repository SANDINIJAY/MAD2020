package com.example.mad20;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class seller3 extends AppCompatActivity {
    TextView textView1;
    Button button2,button3,button4;
    CheckBox checkBox,checkBox2,checkBox3,checkBox4;
    EditText editText2,editText7,editText8,editText9;

    DatabaseReference databaseList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seller3);

        databaseList = FirebaseDatabase.getInstance().getReference("Lists");

        editText2 = (EditText) findViewById(R.id.editText2);
        editText7 = (EditText) findViewById(R.id.editText7);
        editText8 = (EditText) findViewById(R.id.editText8);
        editText9 = (EditText) findViewById(R.id.editText9);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        checkBox = (CheckBox) findViewById(R.id.checkBox);
        checkBox2 = (CheckBox) findViewById(R.id.checkBox2);
        checkBox3 = (CheckBox) findViewById(R.id.checkBox3);
        checkBox4 = (CheckBox) findViewById(R.id.checkBox4);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addList();
            }
        });
    }
    private void addList(){

        String qty1 = editText2.getText().toString().trim();
        String qty2 = editText7.getText().toString().trim();
        String qty3 = editText8.getText().toString().trim();
        String qty4 = editText9.getText().toString().trim();
        if(!TextUtils.isEmpty(qty1)){

            String id = databaseList.push().getKey();

            List list = new List(id,qty1,qty2,qty3,qty4);

            databaseList.child(id).setValue(list);
            Toast.makeText(this,"L      ist aded",Toast.LENGTH_LONG).show();

            }else{
                Toast.makeText(this, "You Should enter a name", Toast.LENGTH_LONG).show();
            }
        }

}
