package application.assignment.calculatora02;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import java.text.DecimalFormat;



import android.os.Bundle;
import android.view.View;

import application.assignment.calculatora02.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ActivityMainBinding binding;
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
    }

    private double valueOne = Double.NaN;
    private double valueTwo;

    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char MULTIPLICATION = '*';
    private static final char DIVISION = '/';

    private char CURRENT_ACTION;

     binding.buttonZero.setOnClickListener(new View.OnClickListener() {
        public void onClick(View view) {
            binding.editText.setText(binding.editText.getText() + "0");
        }
    };

    private void computeCalculation() {
        if(!Double.isNaN(valueOne)) {
            valueTwo = Double.parseDouble(binding.editText.getText().toString());
            binding.editText.setText(null);

            if(CURRENT_ACTION == ADDITION)
                valueOne = this.valueOne + valueTwo;
            else if(CURRENT_ACTION == SUBTRACTION)
                valueOne = this.valueOne - valueTwo;
            else if(CURRENT_ACTION == MULTIPLICATION)
                valueOne = this.valueOne * valueTwo;
            else if(CURRENT_ACTION == DIVISION)
                valueOne = this.valueOne / valueTwo;
        }
        else {
            try {
                valueOne = Double.parseDouble(binding.editText.getText().toString());
            }
            catch (Exception e){}
        }
    }

            binding.buttonAdd.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            computeCalculation();
            CURRENT_ACTION = ADDITION;
            binding.infoTextView.setText(decimalFormat.format(valueOne) + "+");
            binding.editText.setText(null);
        }
    });

        binding.buttonSubtract.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            computeCalculation();
            CURRENT_ACTION = SUBTRACTION;
            binding.infoTextView.setText(decimalFormat.format(valueOne) + "-");
            binding.editText.setText(null);
        }
    });

        binding.buttonMultiply.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            computeCalculation();
            CURRENT_ACTION = MULTIPLICATION;
            binding.infoTextView.setText(decimalFormat.format(valueOne) + "*");
            binding.editText.setText(null);
        }
    });

        binding.buttonDivide.setOnClickListener(new View.OnClickListener() {

        public void onClick(View view) {
            computeCalculation();
            CURRENT_ACTION = DIVISION;
            binding.infoTextView.setText(decimalFormat.format(valueOne) + "/");
            binding.editText.setText(null);
        }
    });

        binding.buttonEqual.setOnClickListener(new View.OnClickListener() {

        public void onClick(View view) {
            computeCalculation();
            binding.infoTextView.setText(binding.infoTextView.getText().toString() +
                    decimalFormat.format(valueTwo) + " = " + decimalFormat.format(valueOne));
            valueOne = Double.NaN;
            CURRENT_ACTION = '0';
        }
    });

}