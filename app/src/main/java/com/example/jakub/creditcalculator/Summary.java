package com.example.jakub.creditcalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Summary extends AppCompatActivity {

    TextView data1;
    TextView data2;
    TextView data3;
    TextView data4;
    TextView data5;
    TextView data6;
    TextView data7;
    TextView data8;
    TextView data9;
    TextView data10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        Bundle extras = getIntent().getExtras();

        data1 = (TextView)findViewById(R.id.textView17);
        data1.setText(extras.getString("DATA1"));

        data2 = (TextView)findViewById(R.id.textView20);
        data2.setText(extras.getString("DATA2"));

        data3 = (TextView)findViewById(R.id.textView22);
        data3.setText(extras.getString("DATA3"));

        data4 = (TextView)findViewById(R.id.textView24);
        data4.setText(extras.getString("DATA4"));

        data5 = (TextView)findViewById(R.id.textView26);
        data5.setText(extras.getString("DATA5"));

        data6 = (TextView)findViewById(R.id.textView28);
        data6.setText(extras.getString("DATA6"));

        data7 = (TextView)findViewById(R.id.textView18);
        data7.setText(extras.getString("DATA7"));

        data8 = (TextView)findViewById(R.id.textView33);
        data8.setText(extras.getString("DATA8"));

        data9 = (TextView)findViewById(R.id.textView34);
        data9.setText(extras.getString("DATA9"));

        data10 = (TextView)findViewById(R.id.textView35);
        data10.setText(extras.getString("DATA10"));
    }

    public void save(View view) {
    }

    public void showInformation(View view) {
        Intent intent = new Intent(this, Information.class);
        startActivity(intent);
    }
}
