package com.example.jakub.creditcalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Summary extends AppCompatActivity {

    TextView result;
    TextView result1;
    TextView result2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        Bundle extras = getIntent().getExtras();

        result = (TextView)findViewById(R.id.textView16);
        result.setText(extras.getString("MESSAGE_DATA"));

        result1 = (TextView)findViewById(R.id.textView18);
        result1.setText(extras.getString("MESSAGE_DATA1"));

        result2 = (TextView)findViewById(R.id.textView17);
        result2.setText(extras.getString("MESSAGE_DATA2"));
    }

    public void save(View view) {
    }
}
