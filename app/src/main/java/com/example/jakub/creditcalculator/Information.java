package com.example.jakub.creditcalculator;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Information extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);
    }

    public void howToCalculate(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.accountingtools.com/credit-terms-cost-of-credit"));
        startActivity(intent);
    }

    public void goToUek(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://uek.krakow.pl/pl/"));
        startActivity(intent);
    }
}
