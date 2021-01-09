package fr.taigaprozz.kanjikana;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import fr.taigaprozz.R;
import fr.taigaprozz.kanjikana.Kana.HiraganaActivity;
import fr.taigaprozz.kanjikana.Kana.KatakanaActivity;
import fr.taigaprozz.kanjikana.Quiz.Quiz;


public class MainActivity extends AppCompatActivity {
    private ImageView kana_start;
    private ImageView kanji_start;
    private ImageView quiz_start;
    private ImageView kana_start_5;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // start hiragana activity with the button
        this.kana_start = findViewById(R.id.hiragana_button);
        kana_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent otherActivity = new Intent(getApplicationContext(), HiraganaActivity.class);
                startActivity(otherActivity);
                finish();
            }
        });

        // start katakana activity with the button
        this.kanji_start = findViewById(R.id.katakana_button);
        kanji_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent otherActivity2 = new Intent(getApplicationContext(), KatakanaActivity.class);
                startActivity(otherActivity2);
                finish();

            }
        });

        // start quiz activity with the button
        this.quiz_start = findViewById(R.id.numbers_start);
        quiz_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent otherActivity3 = new Intent(getApplicationContext(), Quiz.class);
                startActivity(otherActivity3);
                finish();
            }
        });
    }
}
