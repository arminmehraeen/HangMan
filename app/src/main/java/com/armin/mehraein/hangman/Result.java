package com.armin.mehraein.hangman;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Result extends AppCompatActivity {

    TextView txt_show ;
    Button btn_again , btn_finish ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        txt_show = findViewById(R.id.text_Show);
        btn_again = findViewById(R.id.btn_again);
        btn_finish = findViewById(R.id.btn_finish);

        btn_again.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Result.this,Main.class);
                startActivity(intent);
                finish();
            }
        });
        btn_finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Intent intent = getIntent();
        String result = intent.getStringExtra("RESULT");
        if (result.equals("WON")){
            txt_show.setText("تو بردی !");
        }else {
            txt_show.setText("تو باختی !");
        }

    }
}
