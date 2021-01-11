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

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // start hiragana activity with the button
        ImageView kana_start = findViewById(R.id.hiragana_button);
        kana_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(new Intent(getApplicationContext(), HiraganaActivity.class));
            }
        });

        // start katakana activity with the button
        ImageView kanji_start = findViewById(R.id.katakana_button);
        kanji_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(new Intent(getApplicationContext(), KatakanaActivity.class));
            }
        });

        // start quiz activity with the button
        ImageView quiz_start = findViewById(R.id.quiz_start);
        quiz_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Quiz.class);
                finish();
                startActivity(intent);
            }
        });
    }
}
