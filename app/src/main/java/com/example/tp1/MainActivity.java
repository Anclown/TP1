package com.example.tp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.CompoundButton;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {
    public static final String PREFERENCES_NAME = "theme_preferences";
    public static final String THEME_KEY = "current_theme";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SharedPreferences preferences = getSharedPreferences(PREFERENCES_NAME, MODE_PRIVATE);
        int theme = preferences.getInt(THEME_KEY, R.style.Theme_TP1);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        applyTheme(theme);
        Switch themeSwitch = findViewById(R.id.switch2);
        themeSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                SharedPreferences preferences = getSharedPreferences(PREFERENCES_NAME, MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                if (isChecked) {
                    editor.putInt(THEME_KEY, R.style.Theme_TP1);
                    applyTheme(R.style.Theme_TP1);
                } else {
                    editor.putInt(THEME_KEY, R.style.Theme_TP11);
                    applyTheme(R.style.Theme_TP11);
                }
                editor.apply();
            }
        });
    }

    private void applyTheme(int theme) {
        setTheme(theme);
        // Update any elements in your layout that are affected by the theme change
    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.d("iut","onResume");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("iut","onStart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("iut","onPause");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("iut","onDestroy");
    }


}