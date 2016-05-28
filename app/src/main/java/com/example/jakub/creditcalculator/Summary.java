package com.example.jakub.creditcalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Summary extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);
    }

    public void save(View view) {
    }

    public void showDetails(View view) {
        Intent intent = new Intent(this, Details.class);
        startActivity(intent);
    }
}
