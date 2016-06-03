package com.example.jakub.creditcalculator;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class LoadFile extends AppCompatActivity {

    EditText data12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_file);

        Bundle extras = getIntent().getExtras();

        data12 = (EditText)findViewById(R.id.editText4);
        data12.setText(extras.getString("DATA12"));
    }

    public void saveChanges(View view) {
        String fileName = "credit";
        File file = new File(Environment.getExternalStorageDirectory(), fileName);
        try {
            FileOutputStream fo = new FileOutputStream(file);
            fo.write(data12.getText().toString().getBytes());
            fo.close();
            Toast.makeText(getApplicationContext(),"Data changed in internal storage/credit", Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
