package com.paavam.livedata;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

public class MainActivity extends AppCompatActivity {

    private TextView tx;
    private AppCompatButton button;

    private Generator generator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        generator = new ViewModelProvider(this).get(Generator.class);

        // Create the observer which updates the UI.
        Observer<Integer> numObserver = new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                tx.setText(integer + "");
            }
        };

        // Observe the LiveData, passing in this activity as the LifecycleOwner and the observer.
        generator.getCurrentNumber().observe(this, numObserver);

    }

    private void init() {
        tx = findViewById(R.id.textView1);
        tx.setText("-1");

        button = findViewById(R.id.appCompatButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                generator.genNewNumber();
            }
        });

        getSupportFragmentManager().beginTransaction().add(R.id.frameLayout, new Fragment1()).commit();
    }

}
