package com.example.test_app_2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;
import androidx.appcompat.app.AppCompatActivity;

public class RaceCalculatorActivity extends AppCompatActivity {
    private EditText timeInput, speedInput, distanceInput;
    private TextView resultText, calculatedVariableText;
    private Button calculateButton;
    private ToggleButton toggleButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_race_calculator);

        timeInput = findViewById(R.id.time_input);
        speedInput = findViewById(R.id.speed_input);
        distanceInput = findViewById(R.id.distance_input);
        resultText = findViewById(R.id.result_text);
        calculatedVariableText = findViewById(R.id.calculated_variable_text);
        calculateButton = findViewById(R.id.calculate_button);
        toggleButton = findViewById(R.id.toggle_button);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate();
            }
        });

        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                calculate();
            }
        });
    }

    private void calculate() {
    String timeStr = timeInput.getText().toString();
    String speedStr = speedInput.getText().toString();
    String distanceStr = distanceInput.getText().toString();

    try {
        if (timeStr.isEmpty() && !speedStr.isEmpty() && !distanceStr.isEmpty()) {
            float speed = Float.parseFloat(speedStr);
            float distance = Float.parseFloat(distanceStr);
            if (speed <= 0 || distance <= 0) {
                throw new NumberFormatException();
            }
            float time = calculateTime(distance, speed);
            resultText.setText(String.valueOf(time));
            calculatedVariableText.setText(getString(R.string.time));
        } else if (speedStr.isEmpty() && !timeStr.isEmpty() && !distanceStr.isEmpty()) {
            float time = Float.parseFloat(timeStr);
            float distance = Float.parseFloat(distanceStr);
            if (time <= 0 || distance <= 0) {
                throw new NumberFormatException();
            }
            float speed = calculateSpeed(distance, time);
            resultText.setText(String.valueOf(speed));
            calculatedVariableText.setText(getString(R.string.speed));
        } else if (distanceStr.isEmpty() && !timeStr.isEmpty() && !speedStr.isEmpty()) {
            float time = Float.parseFloat(timeStr);
            float speed = Float.parseFloat(speedStr);
            if (time <= 0 || speed <= 0) {
                throw new NumberFormatException();
            }
            float distance = calculateDistance(speed, time);
            resultText.setText(String.valueOf(distance));
            calculatedVariableText.setText(getString(R.string.distance));
        }
    } catch (NumberFormatException e) {
        if (timeStr.isEmpty() || !isNumeric(timeStr) || Float.parseFloat(timeStr) <= 0) {
            timeInput.setError(getString(R.string.invalid_input_zero_or_negative));
        }
        if (speedStr.isEmpty() || !isNumeric(speedStr) || Float.parseFloat(speedStr) <= 0) {
            speedInput.setError(getString(R.string.invalid_input_zero_or_negative));
        }
        if (distanceStr.isEmpty() || !isNumeric(distanceStr) || Float.parseFloat(distanceStr) <= 0) {
            distanceInput.setError(getString(R.string.invalid_input_zero_or_negative));
        }
    }
}

    private boolean isNumeric(String str) {
        try {
            Float.parseFloat(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }

    public float calculateTime(float distance, float speed) {
        return distance / speed;
    }

    public float calculateSpeed(float distance, float time) {
        return distance / time;
    }

    public float calculateDistance(float speed, float time) {
        return speed * time;
    }

    public float convertMetersToFeet(float meters) {
        return meters * 3.28084f;
    }

    public float convertFeetToMeters(float feet) {
        return feet * 0.3048f;
    }

}