package fr.taigaprozz.kanjikana.main;


import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import fr.taigaprozz.R;
import fr.taigaprozz.kanjikana.kana.HiraganaActivity;
import fr.taigaprozz.kanjikana.kana.KatakanaActivity;
import fr.taigaprozz.kanjikana.quiz.SettingsQuiz;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // start hiragana activity with the button
        TextView hiraganaActivityImageMain = findViewById(R.id.hiragana_button);
        hiraganaActivityImageMain.setOnClickListener(v -> {
            finish();
            startActivity(new Intent(getApplicationContext(), HiraganaActivity.class));
        });

        // start katakana activity with the button
        TextView katakanaActivityMainImage = findViewById(R.id.katakana_button);
        katakanaActivityMainImage.setOnClickListener(v -> {
            finish();
            startActivity(new Intent(getApplicationContext(), KatakanaActivity.class));
        });

        // start quiz activity with the button
        TextView quizActivityMainImage = findViewById(R.id.quiz_start);
        quizActivityMainImage.setOnClickListener(v -> {
            finish();
            startActivity(new Intent(getApplicationContext(), SettingsQuiz.class));
        });

        ImageView settingsApp = findViewById(R.id.settings_app);
        settingsApp.setOnClickListener(v -> {
            finish();
            startActivity(new Intent(getApplicationContext(), SettingsActivity.class));
        });

    }
}