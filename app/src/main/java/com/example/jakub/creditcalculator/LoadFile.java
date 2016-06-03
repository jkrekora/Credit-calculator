package com.example.jakub.creditcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

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
}
