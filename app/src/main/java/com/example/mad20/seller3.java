package com.example.mad20;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
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
        button3.setOnItemLongCickListner(new AdapterView.OnItemLongClickListener(){
            @Override
                    public  boolean onItemLongClick(AdapterView<?> adapterView,View view,int i,long l) {

                List list = lists.get(i);
                showUpdateDialog(list.getListID(),list.item1,list.item2,list.item3,list.item4);

                return false;
            }
        });
    }
    private void showUpdateDialog(final String listID, final String item1, final String item2, final String item3, final String item4){
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.update_dialog,null);
        dialogBuilder.setView(dialogView);
        final EditText editText2= (EditText) dialogView.findViewById(R.id.editText2);
        final EditText editText7= (EditText) dialogView.findViewById(R.id.editText7);
        final EditText editText8= (EditText) dialogView.findViewById(R.id.editText8);
        final EditText editText9= (EditText) dialogView.findViewById(R.id.editText9);
        final Button button3= (Button) dialogView.findViewById(R.id.button3);

        dialogBuilder.setTitle("Updaing Items" + listID);
        final AlertDialog alertDialog = dialogBuilder.create();
        alertDialog.show();

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String qty1 = editText2.getText().toString().trim();
                String qty2 = editText7.getText().toString().trim();
                String qty3 = editText8.getText().toString().trim();
                String qty4 = editText9.getText().toString().trim();
                if(!TextUtils.isEmpty(qty1)){

                    editText2.setError("item required");
                    return;

                }
                updateList(listID,item1,item2,item3,item4);

                alertDialog.dismiss();


            }
        });


    }
    private boolean updateList(String listID,String item1,String item2,String item3,String item4){
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("lists").child(listID);
        List list = new List(listID,item1,item2,item3,item4);
        databaseReference.setValue(list);
        Toast.makeText(this,"list updated successfully",Toast.LENGTH_LONG).show();
        return true;
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
            Toast.makeText(this,"List added",Toast.LENGTH_LONG).show();

            }else{
                Toast.makeText(this, "You Should enter a name", Toast.LENGTH_LONG).show();
            }
        }

}
