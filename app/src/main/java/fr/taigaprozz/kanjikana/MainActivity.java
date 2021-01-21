package fr.taigaprozz.kanjikana;


import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import fr.taigaprozz.R;
import fr.taigaprozz.kanjikana.Kana.HiraganaActivity;
import fr.taigaprozz.kanjikana.Kana.KatakanaActivity;
import fr.taigaprozz.kanjikana.Quiz.SettingsQuiz;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // start hiragana activity with the button
        ImageView hiraganaActivityImageMain = findViewById(R.id.hiragana_button);
        hiraganaActivityImageMain.setOnClickListener(v -> {
            finish();
            startActivity(new Intent(getApplicationContext(), HiraganaActivity.class));
        });

        // start katakana activity with the button
        ImageView katakanaActivityMainImage = findViewById(R.id.katakana_button);
        katakanaActivityMainImage.setOnClickListener(v -> {
            finish();
            startActivity(new Intent(getApplicationContext(), KatakanaActivity.class));
        });

        // start quiz activity with the button
        ImageView quizActivityMainImage = findViewById(R.id.quiz_start);
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
