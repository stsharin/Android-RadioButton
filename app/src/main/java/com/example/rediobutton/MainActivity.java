package com.example.rediobutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText input;
    TextView showResult;
    RadioButton r1, r2,r3;
    Button reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input = findViewById(R.id.edit_input);
        showResult = findViewById(R.id.edit_show);
        r1 = findViewById(R.id.rd1);
        r2 = findViewById(R.id.rd2);
        r3 = findViewById(R.id.rd3);
        reset = findViewById(R.id.btn_reset);

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText("");
                showResult.setText("");
            }
        });

    }

    public void con(View v){
        try {
            Double value = new Double(input.getText().toString()); // convert to double

            if(r1.isChecked()){
                double result = LengthConverter.mtocm(value);
                showResult.setText(new Double(result).toString());
            }


            else if (r2.isChecked()){
                double result = LengthConverter.cmtom(value);
                showResult.setText(new Double(result).toString());
            }

            else {
                double result = LengthConverter.mtokm(value);
                showResult.setText(new Double(result).toString());
            }
        }
        catch (Exception e){
            Toast.makeText(getApplicationContext(), "Empty Input", Toast.LENGTH_LONG).show();
        }
    }


}
