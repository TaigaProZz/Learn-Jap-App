package fr.taigaprozz.kanjikana.Quiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

import fr.taigaprozz.R;
import fr.taigaprozz.kanjikana.MainActivity;


public class Quiz extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_quiz);

        TextView backArrow;
        Random r = new Random();

        backArrow = findViewById(R.id.backArrow);
        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(back);
                finish();
            }
        });





    }

    // bouton retour avec bouton du phone
    @Override
    public void onBackPressed()
    {
        Intent i = new Intent(Quiz.this, MainActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);
        finish ();
    }

}