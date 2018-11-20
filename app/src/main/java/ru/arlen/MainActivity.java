package ru.arlen;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {
private static final String STATE_COUNT = "STATE_COUNT";
    private int counter = 0;

    private TextView textView;
    private View incrementBtn, resetBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        incrementBtn = findViewById(R.id.increment);
        resetBtn = findViewById(R.id.reset);

        incrementBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter++;
                showCounter();
            }
        });
        resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter = 0;
                showCounter();
            }
        });

        if (savedInstanceState != null) {
            counter = savedInstanceState.getInt(STATE_COUNT, 0);
        }

        showCounter();
    }

    @SuppressLint("SetTextI18n")
    private void showCounter() {
        textView.setText(Integer.toString(counter));
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(STATE_COUNT, counter);
    }
}
