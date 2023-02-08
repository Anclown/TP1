package com.example.tp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.material.textfield.TextInputEditText;

public class Detail_Activity extends AppCompatActivity {
    static String KEY_NAME = "name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        String maChaine = getIntent().getStringExtra("name");
        if (maChaine != null) {
            Log.e("get message", maChaine);
            TextInputEditText t = findViewById(R.id.textInputEditText2);
            t.setText(maChaine);
        }
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                /*Intent i = new Intent();
                i.putExtra("tintin","milou");
                setResult(RESULT_OK, i);*/
            }
        });
    }
}