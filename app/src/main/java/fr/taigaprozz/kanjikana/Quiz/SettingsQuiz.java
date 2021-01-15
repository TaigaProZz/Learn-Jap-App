package fr.taigaprozz.kanjikana.Quiz;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import fr.taigaprozz.R;
import fr.taigaprozz.kanjikana.MainActivity;

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

        hiraganaLevel1.setOnClickListener(v -> {
            finish();
            startActivity(new Intent(getApplicationContext(), Quiz.class));
            Levels.getInstance().setLevel_hiragana(1);
        });

        hiraganaLevel2.setOnClickListener(v -> {
            finish();
            startActivity(new Intent(getApplicationContext(), Quiz.class));
            Levels.getInstance().setLevel_hiragana(2);
        });

        hiraganaLevel3.setOnClickListener(v -> {
            finish();
            startActivity(new Intent(getApplicationContext(), Quiz.class));
            Levels.getInstance().setLevel_hiragana(3);
        });

        katakanaLevel1.setOnClickListener(v -> {
            finish();
            startActivity(new Intent(getApplicationContext(), Quiz.class));
            Levels.getInstance().setLevel_katakana(1);
        });

        katakanaLevel2.setOnClickListener(v -> {
            finish();
            startActivity(new Intent(getApplicationContext(), Quiz.class));
            Levels.getInstance().setLevel_katakana(2);
        });

        katakanaLevel3.setOnClickListener(v -> {
            finish();
            startActivity(new Intent(getApplicationContext(), Quiz.class));
            Levels.getInstance().setLevel_katakana(3);
        });

        backArrow.setOnClickListener(v -> {
            finish();
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
        });

    }
}