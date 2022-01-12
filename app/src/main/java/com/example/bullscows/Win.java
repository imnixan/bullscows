package com.example.bullscows;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Win extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.win);
        TextView number = findViewById(R.id.number);
        Bundle args = getIntent().getExtras();
        number.setText(args.getString("number"));
        Button play = findViewById(R.id.play);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Win.this, BullsCows.class);
                startActivity(intent);
                finish();
            }
        });

    }
}
