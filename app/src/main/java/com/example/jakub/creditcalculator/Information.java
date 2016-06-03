package com.example.jakub.creditcalculator;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Information extends AppCompatActivity {

    TextView information;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        information = (TextView)findViewById(R.id.textView36);
        information.setText("Additional credit costs may be:\n\n" +
                "> margin of the bank or lending company\n" +
                "> the cost of servicing the loan\n" +
                "> the commission for the bank\n" +
                "> the costs associated with credit insurance");
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
