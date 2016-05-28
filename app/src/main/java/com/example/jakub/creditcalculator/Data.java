package com.example.jakub.creditcalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Data extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);
    }

    public void calculate(View view) {
        Intent intent = new Intent(this, Summary.class);
        startActivity(intent);
    }

    public void reset(View view) {
        Intent intent = new Intent(this, Data.class);
        startActivity(intent);
    }
}
