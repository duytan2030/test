package com.example.demogiuaki;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileOutputStream;
import java.io.Serializable;
import java.security.Key;
import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;

public class MainActivity extends AppCompatActivity {
    public static final String KEY_FileName = "FileName";
    public static final String KEY_Content = "Content";
    public static final String KEY_Bundel = "Bundel";
    public static final String KEY_List = "List";

    Intent intent;
    EditText ed_nhap, ed_content;
    Button bt_nhapmoi, bt_luu, bt_xem;
    ArrayList list = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Intent i = new Intent(MainActivity.this, Main2Activity.class);
        setContentView(R.layout.activity_main);
        ed_content = (EditText) findViewById(R.id.ed_content);
        ed_nhap = (EditText) findViewById(R.id.ed_nhapten);
        bt_luu = (Button) findViewById(R.id.bt_luu);
        bt_nhapmoi = (Button) findViewById(R.id.bt_nhapmoi);
        bt_xem = (Button) findViewById(R.id.bt_xem);
        intent = new Intent();
        intent.setClass(MainActivity.this, Main2Activity.class);
        list.add("hello");

         bt_nhapmoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ed_nhap.setText("");
                ed_content.setText("");
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("hello");
                builder.setMessage("thong bao ne!!");
                builder.setPositiveButton("Khong", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                builder.setNegativeButton("co", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                AlertDialog dialog= builder.create();
                dialog.show();

            }
        });
        bt_xem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Bundle bundle = new Bundle();

//                bundle.putString(KEY_FileName, ed_nhap.getText().toString());
//                bundle.putString(KEY_Content, ed_content.getText().toString());




                //intent.putExtra(KEY_Bundel, bundle);
                startActivity(intent);
            }
        });
        bt_luu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                list.add(ed_nhap.getText().toString());
                intent.putExtra(KEY_List,list);


                String filename = ed_nhap.getText().toString();
                try {
                    FileOutputStream fileOutputStream = openFileOutput(filename, MODE_PRIVATE);
                    fileOutputStream.write(ed_content.getText().toString().getBytes());
                    fileOutputStream.close();
                }
                catch (Exception e){}
                Toast.makeText(MainActivity.this,"loi luu",Toast.LENGTH_SHORT).toString();


            }
        });
    }
}
