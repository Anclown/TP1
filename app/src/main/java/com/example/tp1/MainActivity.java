package com.example.tp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {
    public static final String PREFERENCES_NAME = "theme_preferences";
    public static final String THEME_KEY = "current_theme";
    private int currentTheme;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        int theme = getIntent().getIntExtra("theme", R.style.Theme_TP11);
        int dark_theme = getIntent().getIntExtra("dark_theme",R.style.Theme_TP11_dark);
        setTheme(theme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = findViewById(R.id.button2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChangeActivity();
            }
        });

        Switch themeSwitch = findViewById(R.id.switch2);
        themeSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                if (getIntent().getIntExtra("theme", R.style.Theme_TP11)==1) {
                    if (isChecked) {
                        intent.putExtra("theme", R.style.Theme_TP11_dark);
                        currentTheme = 1;
                    } else {
                        intent.putExtra("theme", R.style.Theme_TP11);
                        currentTheme = 0;
                    }
                }
                else {
                    if (!isChecked) {
                        intent.putExtra("theme", R.style.Theme_TP11);
                        currentTheme = 0;
                    } else {
                        intent.putExtra("theme", R.style.Theme_TP11_dark);
                        currentTheme = 1;
                    }
                }
                startActivity(intent);
                finish();
            }
        });
    }

    private void ChangeActivity() {
        Intent myIntent = new Intent(MainActivity.this, Detail_Activity.class);
        myIntent.putExtra("MessageKey", " le message ");
        startActivity(myIntent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("iut", "onResume");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("iut", "onStart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("iut", "onPause");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("iut", "onDestroy");
    }


}