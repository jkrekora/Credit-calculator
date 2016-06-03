package com.example.jakub.creditcalculator;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Environment;
import android.renderscript.Double2;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;

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
        String data1 = new BigDecimal(comSize).setScale(2, BigDecimal.ROUND_HALF_UP).toString();
        String data2 = new BigDecimal(creditAmount1).setScale(2, BigDecimal.ROUND_HALF_UP).toString();
        String data3 = new BigDecimal(amountToBePaid).setScale(2, BigDecimal.ROUND_HALF_UP).toString();
        String data4 = interestRate.getText().toString() + "%";
        String data5 = loanPeriod.getText().toString() + " month(s)";

        fund = installment;
        crAmount = creditAmount1;
        String data7 = "";
        String data8 = "";
        String data9 = "";
        String data10 = "";
        String data11 = "";

        spinner1.getSelectedItemId();
        if (spinner1.getSelectedItemId() == 0) {
            for (int i = 1; i <= loanPeriod1; i++){
                crAmount = crAmount - fund;
                interest= (crAmount) * interestRate1 / 12;
                installment = creditAmount1 * interestRate1 / 12 * (Math.pow((1 + interestRate1 / 12), loanPeriod1) / (Math.pow((1 + interestRate1 / 12), loanPeriod1) - 1));
                fund = installment - interest;
                costOfCredit = costOfCredit + installment;
                String[] message1 = new String[i];
                String[] message2 = new String[i];
                String[] message3 = new String[i];
                String[] message4 = new String[i];
                String[] message5 = new String[i];
                message1[i-1] = (i + "\n");
                message2[i-1] = (new BigDecimal(interest).setScale(2, BigDecimal.ROUND_HALF_UP).toString() + "\n");
                message3[i-1] = (new BigDecimal(fund).setScale(2, BigDecimal.ROUND_HALF_UP).toString() + "\n");
                message4[i-1] = (new BigDecimal(installment).setScale(2, BigDecimal.ROUND_HALF_UP).toString() + "\n");
                message5[i-1] = (i + "   " + new BigDecimal(interest).setScale(2, BigDecimal.ROUND_HALF_UP).toString() + "   " + new BigDecimal(fund).setScale(2, BigDecimal.ROUND_HALF_UP).toString() + "   " + new BigDecimal(installment).setScale(2, BigDecimal.ROUND_HALF_UP).toString() + "\n");
                data7 = new StringBuilder(data7).append(message1[i-1]).toString();
                data8 = new StringBuilder(data8).append(message2[i-1]).toString();
                data9 = new StringBuilder(data9).append(message3[i-1]).toString();
                data10 = new StringBuilder(data10).append(message4[i-1]).toString();
                data11 = new StringBuilder(data11).append(message5[i-1]).toString();
                intent.putExtra("DATA7", data7);
                intent.putExtra("DATA8", data8);
                intent.putExtra("DATA9", data9);
                intent.putExtra("DATA10", data10);
                intent.putExtra("DATA11", data11);
            }
            String data6 = new BigDecimal(costOfCredit).setScale(2, BigDecimal.ROUND_HALF_UP).toString();
            intent.putExtra("DATA6", data6);
        }

        if (spinner1.getSelectedItemId() == 1) {
            for (int i = 1; i <= loanPeriod1; i++) {
                crAmount = crAmount - fund;
                interest = (crAmount) * interestRate1 / 12;
                installment = (creditAmount1 / loanPeriod1) * (1 + (loanPeriod1 - i + 1) * interestRate1 / 12);
                fund = installment - interest;
                costOfCredit = costOfCredit + installment;
                String[] message1 = new String[i];
                String[] message2 = new String[i];
                String[] message3 = new String[i];
                String[] message4 = new String[i];
                String[] message5 = new String[i];
                message1[i-1] = (i + "\n");
                message2[i-1] = (new BigDecimal(interest).setScale(2, BigDecimal.ROUND_HALF_UP).toString() + "\n");
                message3[i-1] = (new BigDecimal(fund).setScale(2, BigDecimal.ROUND_HALF_UP).toString() + "\n");
                message4[i-1] = (new BigDecimal(installment).setScale(2, BigDecimal.ROUND_HALF_UP).toString() + "\n");
                message5[i-1] = (i + "   " + new BigDecimal(interest).setScale(2, BigDecimal.ROUND_HALF_UP).toString() + "   " + new BigDecimal(fund).setScale(2, BigDecimal.ROUND_HALF_UP).toString() + "   " + new BigDecimal(installment).setScale(2, BigDecimal.ROUND_HALF_UP).toString() + "\n");
                data7 = new StringBuilder(data7).append(message1[i-1]).toString();
                data8 = new StringBuilder(data8).append(message2[i-1]).toString();
                data9 = new StringBuilder(data9).append(message3[i-1]).toString();
                data10 = new StringBuilder(data10).append(message4[i-1]).toString();
                data11 = new StringBuilder(data11).append(message5[i-1]).toString();
                intent.putExtra("DATA7", data7);
                intent.putExtra("DATA8", data8);
                intent.putExtra("DATA9", data9);
                intent.putExtra("DATA10", data10);
                intent.putExtra("DATA11", data11);
            }
            String data6 = new BigDecimal(costOfCredit).setScale(2, BigDecimal.ROUND_HALF_UP).toString();
            intent.putExtra("DATA6", data6);
        }
        intent.putExtra("DATA1", data1);
        intent.putExtra("DATA2", data2);
        intent.putExtra("DATA3", data3);
        intent.putExtra("DATA4", data4);
        intent.putExtra("DATA5", data5);

        if(creditAmount1 == 0.00){
            Toast.makeText(getBaseContext(),"Enter credit amount!", Toast.LENGTH_SHORT).show();
        }
        else if(spinner.getSelectedItemId() == 1 && commissionSize1 == 0.00 || spinner.getSelectedItemId() == 2 && commissionSize1 == 0.00 || spinner.getSelectedItemId() == 3 && commissionSize1 == 0.00){
            Toast.makeText(getBaseContext(),"Enter commission size!", Toast.LENGTH_SHORT).show();
        }
        else if(interestRate1 == 0.00){
            Toast.makeText(getBaseContext(),"Enter interest rate!", Toast.LENGTH_SHORT).show();
        }
        else if(loanPeriod1 == 0.00){
            Toast.makeText(getBaseContext(),"Enter loan period!", Toast.LENGTH_SHORT).show();
        }
        else {
            startActivity(intent);
        }

    }

    public void reset(View view) {
        creditAmount.setText("");
        commissionSize.setText("");
        interestRate.setText("");
        loanPeriod.setText("");
        spinner.setSelection(0);
        spinner1.setSelection(0);
    }

    public void loadFile(View view) {
        Intent intent = new Intent(this, LoadFile.class);
        String path = Environment.getExternalStorageDirectory() + "/" + "credit";
        File file = new File(path);
        try {
            FileInputStream fi = new FileInputStream(file);
            int length = (int)file.length();
            byte bytes[] = new byte[length];
            fi.read(bytes);
            String data12 = new String(bytes);
            intent.putExtra("DATA12", data12);
            startActivity(intent);
        } catch (IOException e) {
            Toast.makeText(getApplicationContext(),"No data to load", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }

    }
}
