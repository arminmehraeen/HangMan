package com.armin.mehraein.hangman;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Main extends AppCompatActivity {

    String word , wordDashed = "";
    TextView txt_show ;
    ImageView face ;
    int failCount = 0 ;
    TextView btn_1, btn_2, btn_3, btn_4, btn_5, btn_6, btn_7, btn_8, btn_9, btn_10, btn_11, btn_12, btn_13, btn_14, btn_15,
            btn_16, btn_17, btn_18, btn_19, btn_20, btn_21, btn_22, btn_23, btn_24, btn_25, btn_26, btn_27, btn_28, btn_29, btn_30, btn_31, btn_32;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        word = selectWord();
        for (int i=0 ; i<word.length() ; i++){
            if (word.charAt(i) != ' '){
                wordDashed += "-" ;
            }else {
                wordDashed += " " ;
            }
        }
        txt_show.setText(wordDashed);
        setOnClickListener();


    }

    private String selectWord() {
        String[] words = {
                "ماکروسافت",
                "گوگل",
                "سامسونگ",
                "سونی",
                "الجی",
                "هاوایی",
                "سونی اریکسون",
                "توشیبا",
                "شارپ",
                "ایکسویژن",
        };
        int indexNumber = (int) (Math.random() * words.length);
        return words[indexNumber];
    }

    private void setOnClickListener() {
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setListener(view);
            }
        };
        btn_1.setOnClickListener(listener);
        btn_2.setOnClickListener(listener);
        btn_3.setOnClickListener(listener);
        btn_4.setOnClickListener(listener);
        btn_5.setOnClickListener(listener);
        btn_6.setOnClickListener(listener);
        btn_7.setOnClickListener(listener);
        btn_8.setOnClickListener(listener);
        btn_9.setOnClickListener(listener);
        btn_10.setOnClickListener(listener);
        btn_11.setOnClickListener(listener);
        btn_12.setOnClickListener(listener);
        btn_13.setOnClickListener(listener);
        btn_14.setOnClickListener(listener);
        btn_15.setOnClickListener(listener);
        btn_16.setOnClickListener(listener);
        btn_17.setOnClickListener(listener);
        btn_18.setOnClickListener(listener);
        btn_19.setOnClickListener(listener);
        btn_20.setOnClickListener(listener);
        btn_21.setOnClickListener(listener);
        btn_22.setOnClickListener(listener);
        btn_23.setOnClickListener(listener);
        btn_24.setOnClickListener(listener);
        btn_25.setOnClickListener(listener);
        btn_26.setOnClickListener(listener);
        btn_27.setOnClickListener(listener);
        btn_28.setOnClickListener(listener);
        btn_29.setOnClickListener(listener);
        btn_30.setOnClickListener(listener);
        btn_31.setOnClickListener(listener);
        btn_32.setOnClickListener(listener);
    }

    private void setListener(View view) {
        TextView textView = (TextView) view ;
        String id = textView.getResources().getResourceEntryName(textView.getId());
        String number = id.replace("btn_","");
        String letter = getWord(number);

        textView.setBackgroundColor(ContextCompat.getColor(Main.this,R.color.colorDark));
        textView.setText("X");
        textView.setClickable(false);

        if (word.contains(letter)){
            for (int i=0 ; i<word.length() ; i++){
                if (word.charAt(i) == letter.charAt(0)){
                    char[] wordDashedChar = wordDashed.toCharArray();
                    wordDashedChar[i] = letter.charAt(0);
                    wordDashed = new String(wordDashedChar);
                    txt_show.setText(wordDashed);
                    if (!wordDashed.contains("-")){
                        Intent intent = new Intent(Main.this,Result.class);
                        intent.putExtra("RESULT","WON");
                        startActivity(intent);
                        finish();
                    }
                }
            }
        }else {
            Log.i("Armin" , "no");
            failCount++;
            if (failCount >= 8){
                Intent intent = new Intent(Main.this,Result.class);
                intent.putExtra("RESULT","WORSE");
                startActivity(intent);
                finish();
            }
            int imgResource ;
            switch (failCount){
                case 1 : imgResource = R.drawable.face_2;break;
                case 2 : imgResource = R.drawable.face_3;break;
                case 3 : imgResource = R.drawable.face_4;break;
                case 4 : imgResource = R.drawable.face_5;break;
                case 5 : imgResource = R.drawable.face_6;break;
                case 6 : imgResource = R.drawable.face_7;break;
                case 7 : imgResource = R.drawable.face_8;break;
                case 8 : imgResource = R.drawable.face_9;break;
                default: imgResource = R.drawable.face_1;break;
            }
            face.setImageResource(imgResource);
        }

    }

    private String getWord(String number) {
        switch (number){
            case "1" : return "ا";
            case "2" : return "ب";
            case "3" : return "پ";
            case "4" : return "ت";
            case "5" : return "ث";
            case "6" : return "ج";
            case "7" : return "چ";
            case "8" : return "ح";
            case "9" : return "خ";
            case "10" : return "د";
            case "11" : return "ذ";
            case "12" : return "ر";
            case "13" : return "ز";
            case "14" : return "ژ";
            case "15" : return "س";
            case "16" : return "ش";
            case "17" : return "ص";
            case "18" : return "ض";
            case "19" : return "ط";
            case "20" : return "ظ";
            case "21" : return "ع";
            case "22" : return "غ";
            case "23" : return "ف";
            case "24" : return "ق";
            case "25" : return "ک";
            case "26" : return "گ";
            case "27" : return "ل";
            case "28" : return "م";
            case "29" : return "ن";
            case "30" : return "و";
            case "31" : return "ه";
            case "32" : return "ی";
            default: return "";
        }
    }

    private void initView() {
        face = findViewById(R.id.face);
        txt_show = findViewById(R.id.text_Show);
        btn_1 = findViewById(R.id.btn_1);
        btn_2 = findViewById(R.id.btn_2);
        btn_3 = findViewById(R.id.btn_3);
        btn_4 = findViewById(R.id.btn_4);
        btn_5 = findViewById(R.id.btn_5);
        btn_6 = findViewById(R.id.btn_6);
        btn_7 = findViewById(R.id.btn_7);
        btn_8 = findViewById(R.id.btn_8);
        btn_9 = findViewById(R.id.btn_9);
        btn_10 = findViewById(R.id.btn_10);
        btn_11 = findViewById(R.id.btn_11);
        btn_12 = findViewById(R.id.btn_12);
        btn_13 = findViewById(R.id.btn_13);
        btn_14 = findViewById(R.id.btn_14);
        btn_15 = findViewById(R.id.btn_15);
        btn_16 = findViewById(R.id.btn_16);
        btn_17 = findViewById(R.id.btn_17);
        btn_18 = findViewById(R.id.btn_18);
        btn_19 = findViewById(R.id.btn_19);
        btn_20 = findViewById(R.id.btn_20);
        btn_21 = findViewById(R.id.btn_21);
        btn_22 = findViewById(R.id.btn_22);
        btn_23 = findViewById(R.id.btn_23);
        btn_24 = findViewById(R.id.btn_24);
        btn_25 = findViewById(R.id.btn_25);
        btn_26 = findViewById(R.id.btn_26);
        btn_27 = findViewById(R.id.btn_27);
        btn_28 = findViewById(R.id.btn_28);
        btn_29 = findViewById(R.id.btn_29);
        btn_30 = findViewById(R.id.btn_30);
        btn_31 = findViewById(R.id.btn_31);
        btn_32 = findViewById(R.id.btn_32);
    }


}
