package com.example.tipcalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;


public class MainActivity extends AppCompatActivity {
    Double percentage = 0.0;
    Double subtotal = 0.0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tip();
    }
    protected void tip(){
        Button fifteenPercentButton = findViewById(R.id.btnPercent15);
        Button twentyPercentButton = findViewById(R.id.btnPercent20);
        Button customPercentButton = findViewById(R.id.btnPercentCustom);
        Button confirmCustomTipButton = findViewById(R.id.btnConfirm);

        EditText subtotalText = findViewById(R.id.txtSubtotal);
        EditText tipPercentage = findViewById(R.id.txtCustomPercent);

        TextView totalLabel = findViewById(R.id.lblTotal);

        LinearLayout tipEntryBar = findViewById(R.id.lytCustomTip);

        tipEntryBar.setVisibility(View.INVISIBLE);

        fifteenPercentButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                tipEntryBar.setVisibility(View.INVISIBLE);
                subtotal = Double.parseDouble(subtotalText.getText().toString());
                percentage = 0.15;
                totalLabel.setText(String.format(Double.toString(calculate(subtotal, percentage))));
            }
        });

        twentyPercentButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                tipEntryBar.setVisibility(View.INVISIBLE);
                subtotal = Double.parseDouble(subtotalText.getText().toString());
                percentage = .2;
                totalLabel.setText(String.format(Double.toString(calculate(subtotal, percentage))));
            }
        });

        customPercentButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                tipEntryBar.setVisibility(View.VISIBLE);
            }
        });

        confirmCustomTipButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                subtotal = Double.parseDouble(subtotalText.getText().toString());
                percentage = Double.parseDouble(tipPercentage.getText().toString()) / 100;
                totalLabel.setText(String.format(Locale.US, "%.2f", calculate(subtotal, percentage)));
            }
        });




    }

    public double calculate(double subtotal, double tip){
        return subtotal + (subtotal*tip);
    }
}


