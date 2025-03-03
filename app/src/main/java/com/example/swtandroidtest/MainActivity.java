package com.example.swtandroidtest;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    public TextView resultTextView;
    private String currentInput = "";
    private String operator = "";
    private double firstValue = 0;
    private boolean isNewInput = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultTextView = findViewById(R.id.resultTextView);

        View.OnClickListener listener = view -> {
            Button button = (Button) view;
            String buttonText = button.getText().toString();

            handleButtonPress(buttonText);
        };

        int[] buttonIds = {
                R.id.button0, R.id.button1, R.id.button2, R.id.button3, R.id.button4,
                R.id.button5, R.id.button6, R.id.button7, R.id.button8, R.id.button9,
                R.id.buttonAdd, R.id.buttonSubtract, R.id.buttonMultiply, R.id.buttonDivide,
                R.id.buttonClear, R.id.buttonEquals
        };

        for (int id : buttonIds) {
            findViewById(id).setOnClickListener(listener);
        }
    }

    public void handleButtonPress(String buttonText) {
        if (buttonText.matches("[0-9]")) {
            if (isNewInput) {
                currentInput = buttonText;
                isNewInput = false;
            } else {
                currentInput += buttonText;
            }
            resultTextView.setText(currentInput);
        } else if (buttonText.equals("C")) {
            resetCalculator();
        } else if (buttonText.equals("=")) {
            calculateResult();
            isNewInput = true;
        } else { // Handle Operators
            if (!currentInput.isEmpty()) {
                firstValue = Double.parseDouble(currentInput);
                operator = buttonText;
                isNewInput = true;
            }
        }
    }

    private void resetCalculator() {
        currentInput = "";
        operator = "";
        firstValue = 0;
        resultTextView.setText("0");
        isNewInput = true;
    }

    private void calculateResult() {
        if (!currentInput.isEmpty() && !operator.isEmpty()) {
            double secondValue = Double.parseDouble(currentInput);
            double result = 0;

            switch (operator) {
                case "+": result = firstValue + secondValue; break;
                case "-": result = firstValue - secondValue; break;
                case "*": result = firstValue * secondValue; break;
                case "/": result = secondValue != 0 ? firstValue / secondValue : 0; break;
            }

            resultTextView.setText(String.valueOf(result));
            currentInput = String.valueOf(result);
            operator = "";
        }
    }
}
