package com.example.jakub.creditcalculator;

import android.content.Intent;
import android.content.SharedPreferences;
import android.renderscript.Double2;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Data extends AppCompatActivity {

    EditText creditAmount;
    EditText commissionSize;
    EditText interestRate;
    EditText loanPeriod;

    Spinner spinner;
    Spinner spinner1;
    ArrayAdapter<CharSequence> adapter;
    ArrayAdapter<CharSequence> adapter1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);

        creditAmount = (EditText)findViewById(R.id.editText);
        commissionSize = (EditText)findViewById(R.id.editText1);
        interestRate = (EditText)findViewById(R.id.editText2);
        loanPeriod = (EditText)findViewById(R.id.editText3);

        spinner = (Spinner)findViewById(R.id.spinner);
        adapter = ArrayAdapter.createFromResource(this, R.array.spinner, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(), parent.getItemAtPosition(position) + " selected", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinner1 = (Spinner)findViewById(R.id.spinner1);
        adapter1 = ArrayAdapter.createFromResource(this, R.array.spinner1, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter1);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(), parent.getItemAtPosition(position) + " selected", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void calculate(View view) {

        Intent intent = new Intent(this, Summary.class);

        double amountToBePaid;
        double crAmount;
        double comSize = 0;
        double installment = 0;
        double costOfCredit = 0;
        double interest;
        double fund;

        Double creditAmount1 = 0.00;
        Double commissionSize1 = 0.00;
        Double interestRate1 = 0.00;
        Double loanPeriod1 = 0.00;

        String text1 = creditAmount.getText().toString();
        if(text1.length()>0){
            creditAmount1 = Double.parseDouble(text1);
        }
        amountToBePaid = creditAmount1;
        crAmount = creditAmount1;

        String text2 = commissionSize.getText().toString();
        if(text2.length()>0) {
            commissionSize1 = Double.parseDouble(text2) / 100;
        }

        String text3 = interestRate.getText().toString();
        if(text3.length()>0) {
            interestRate1 = Double.parseDouble(text3) / 100;
        }

        String text4 = loanPeriod.getText().toString();
        if(text4.length()>0) {
            loanPeriod1 = Double.parseDouble(text4);
        }

        double loanPeriod2 = loanPeriod1;
        int loanPeriod3 = (int) loanPeriod2;

        spinner.getSelectedItemId();
        if (spinner.getSelectedItemId() == 1) {
            comSize = commissionSize1;
            creditAmount1 = creditAmount1 + creditAmount1 * commissionSize1;
        }
        else if (spinner.getSelectedItemId() == 2) {
            comSize = commissionSize1;
            amountToBePaid = creditAmount1 - creditAmount1 * commissionSize1;
        }
        else if (spinner.getSelectedItemId() == 3) {
            comSize = commissionSize1;
        }

        if (spinner.getSelectedItemId() != 0){
            comSize = comSize * crAmount;
        }
        String message = ("Commission size: " + comSize +"\n" + "Credit amount: " + creditAmount1 + "\n" + "Amount to be paid: "
                + amountToBePaid + "\n" + "Interest rate: " + interestRate1 * 100 + "%\n" + "Loan period: " + loanPeriod3 + " months");

        fund = installment;
        crAmount = creditAmount1;
        String message1 = "";

        spinner1.getSelectedItemId();
        if (spinner1.getSelectedItemId() == 0) {
            for (int i = 1; i <= loanPeriod1; i++){
                crAmount = crAmount - fund;
                interest= (crAmount) * interestRate1 / 12;
                interest = interest * 100;
                interest = Math.round(interest);
                interest = interest / 100;
                installment = creditAmount1 * interestRate1 / 12 * (Math.pow((1 + interestRate1 / 12), loanPeriod1) / (Math.pow((1 + interestRate1 / 12), loanPeriod1) - 1));
                fund = installment - interest;
                fund = fund * 100;
                fund = Math.round(fund);
                fund = fund / 100;
                costOfCredit = costOfCredit + installment;
                installment = installment * 100;
                installment = Math.round(installment);
                installment = installment / 100;
                String[] text = new String[i];
                text[i-1] = ("No " + i + " Interest: " + interest + " Fund: " + fund + " Installment: " + installment + "\n");
                message1 = new StringBuilder(message1).append(text[i-1]).toString();
                intent.putExtra("MESSAGE_DATA1", message1);
            }
            costOfCredit = costOfCredit * 100;
            costOfCredit = Math.round(costOfCredit);
            costOfCredit = costOfCredit / 100;
            String message2 = ("Payments sum: " + costOfCredit);
            intent.putExtra("MESSAGE_DATA2", message2);
        }

        if (spinner1.getSelectedItemId() == 1) {
            for (int i = 1; i <= loanPeriod1; i++) {
                crAmount = crAmount - fund;
                interest = (crAmount) * interestRate1 / 12;
                interest = interest * 100;
                interest = Math.round(interest);
                interest = interest / 100;
                installment = (creditAmount1 / loanPeriod1) * (1 + (loanPeriod1 - i + 1) * interestRate1 / 12);
                fund = installment - interest;
                fund = fund * 100;
                fund = Math.round(fund);
                fund = fund / 100;
                costOfCredit = costOfCredit + installment;
                installment = installment * 100;
                installment = Math.round(installment);
                installment = installment / 100;
                String[] text = new String[i];
                text[i-1] = ("No " + i + " Interest: " + interest + " Fund: " + fund + " Installment: " + installment + "\n");
                message1 = new StringBuilder(message1).append(text[i-1]).toString();
                intent.putExtra("MESSAGE_DATA1", message1);
            }
            costOfCredit = costOfCredit * 100;
            costOfCredit = Math.round(costOfCredit);
            costOfCredit = costOfCredit / 100;
            String message2 = ("Payments sum: " + costOfCredit);
            intent.putExtra("MESSAGE_DATA2", message2);
        }
        intent.putExtra("MESSAGE_DATA", message);
        startActivity(intent);

    }

    public void reset(View view) {
        creditAmount.setText("");
        commissionSize.setText("");
        interestRate.setText("");
        loanPeriod.setText("");
        spinner.setSelection(0);
        spinner1.setSelection(0);
    }
}
