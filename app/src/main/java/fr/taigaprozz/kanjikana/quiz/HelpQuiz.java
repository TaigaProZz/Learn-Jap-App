package fr.taigaprozz.kanjikana.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import fr.taigaprozz.R;

public class HelpQuiz extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_quiz);

        TextView backArrow = findViewById(R.id.goingBackArrow);

        backArrow.setOnClickListener(v -> {
            finish();
            startActivity(new Intent(getApplicationContext(), SettingsQuiz.class));
        });

    }

    // return button of the phone
    @Override
    public void onBackPressed() {
        finish();
        startActivity(new Intent(getApplicationContext(), SettingsQuiz.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
    }
}