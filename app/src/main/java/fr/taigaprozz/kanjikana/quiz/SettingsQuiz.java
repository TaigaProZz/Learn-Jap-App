package fr.taigaprozz.kanjikana.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import fr.taigaprozz.R;
import fr.taigaprozz.kanjikana.main.MainActivity;

public class SettingsQuiz extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_quiz);

        // collect all components in layout
        TextView backArrow = findViewById(R.id.goingBackArrow);
        Button hiraganaLevel1 = findViewById(R.id.hiragana_level1);
        Button hiraganaLevel2 = findViewById(R.id.hiragana_level2);
        Button hiraganaLevel3 = findViewById(R.id.hiragana_level3);
        Button katakanaLevel1 = findViewById(R.id.katakana_level1);
        Button katakanaLevel2 = findViewById(R.id.katakana_level2);
        Button katakanaLevel3 = findViewById(R.id.katakana_level3);
        TextView help = findViewById(R.id.help_quiz);

        help.setOnClickListener(v -> {
            finish();
            startActivity(new Intent(getApplicationContext(), HelpQuiz.class));
        });

        hiraganaLevel1.setOnClickListener(v -> {
            finish();
            startActivity(new Intent(getApplicationContext(), Quiz.class));
            Levels.getInstance().setLevelHiragana(1);
        });

        hiraganaLevel2.setOnClickListener(v -> {
            finish();
            startActivity(new Intent(getApplicationContext(), Quiz.class));
            Levels.getInstance().setLevelHiragana(2);
        });

        hiraganaLevel3.setOnClickListener(v -> {
            finish();
            startActivity(new Intent(getApplicationContext(), Quiz.class));
            Levels.getInstance().setLevelHiragana(3);
        });

        katakanaLevel1.setOnClickListener(v -> {
            finish();
            startActivity(new Intent(getApplicationContext(), Quiz.class));
            Levels.getInstance().setLevelKatakana(1);
        });

        katakanaLevel2.setOnClickListener(v -> {
            finish();
            startActivity(new Intent(getApplicationContext(), Quiz.class));
            Levels.getInstance().setLevelKatakana(2);
        });

        katakanaLevel3.setOnClickListener(v -> {
            finish();
            startActivity(new Intent(getApplicationContext(), Quiz.class));
            Levels.getInstance().setLevelKatakana(3);
        });

        backArrow.setOnClickListener(v -> {
            finish();
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
        });

    }

    // return button of the phone
    @Override
    public void onBackPressed() {
        finish();
        startActivity(new Intent(getApplicationContext(), MainActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
    }
}