package fr.taigaprozz.kanjikana;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.fonts.Font;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.FontResourcesParserCompat;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import fr.taigaprozz.R;
import fr.taigaprozz.kanjikana.Kana.HiraganaActivity;
import fr.taigaprozz.kanjikana.Kana.KatakanaActivity;
import fr.taigaprozz.kanjikana.Kanji.KanjiActivity;
import fr.taigaprozz.kanjikana.Numbers.NumbersActivity;


public class MainActivity extends AppCompatActivity {
    private ImageView kana_start;
    private ImageView kanji_start;
    private ImageView numbers_start;
    private ImageView kana_start_5;



    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        this.kana_start = findViewById(R.id.hiragana_button);
        kana_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent otherActivity = new Intent(getApplicationContext (), HiraganaActivity.class);
                startActivity (otherActivity);
                finish ();
            }
        }   );


        this.kanji_start = findViewById (R.id.katakana_button);
        kanji_start.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent otherActivity2 = new Intent (getApplicationContext (), KatakanaActivity.class);
                startActivity (otherActivity2);
                finish ();

            }
        }   );


        this.numbers_start = findViewById (R.id.numbers_start);
        numbers_start.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent otherActivity3 = new Intent (getApplicationContext (), NumbersActivity.class);
                startActivity (otherActivity3);
                finish ();
            }
        }   );


        kana_start_5 = findViewById (R.id.kana_start5);
        kana_start_5.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent otherActivity4 = new Intent (getApplicationContext (), TabbedActivity.class);
                startActivity (otherActivity4);
                finish ();
            }
        }   );




    }
}
