package com.example.demogiuaki;

import androidx.annotation.MainThread;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {
    Spinner sp_filename;

    ArrayAdapter arrayAdapter;
    EditText ed_content, ed_ten;
    Button bt_mo;
    ArrayList<String> imageslist;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        sp_filename = (Spinner) findViewById(R.id.spinner_File);
        sp_filename.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                ed_ten.setText(imageslist.get(i).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        bt_mo = (Button) findViewById(R.id.bt_mo);
        ed_content = (EditText) findViewById(R.id.ed_noidung);
        ed_ten = (EditText) findViewById(R.id.ed_filenameMain2);


        imageslist = (ArrayList<String>) getIntent().getSerializableExtra(MainActivity.KEY_List);

//          ed_content.setText(data.getStringExtra(MainActivity.KEY_Content));
//          ed_ten.setText(data.getStringExtra(MainActivity.KEY_FileName));
        arrayAdapter = new ArrayAdapter(Main2Activity.this, android.R.layout.simple_list_item_single_choice, imageslist);
        sp_filename.setAdapter(arrayAdapter);


        bt_mo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fileName = ed_ten.getText().toString();
                StringBuffer stringBuffer = new StringBuffer();
                String line = null;
                try {
                    FileInputStream fileInputStream = openFileInput(fileName);
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
                    while ((line = bufferedReader.readLine()) != null) {

                        stringBuffer.append(line).append(("\n"));
                        ed_content.setText(stringBuffer.toString());
                    }

                } catch (Exception e) {

                    Toast.makeText(Main2Activity.this, "loi", Toast.LENGTH_LONG).show();

                }
                backClicked(view);
            }
        });


    }

    public void backClicked(View view) {
        // Gọi phương thức onBackPressed().
        this.onBackPressed();
    }
}
