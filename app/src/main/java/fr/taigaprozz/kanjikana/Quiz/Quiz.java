package fr.taigaprozz.kanjikana.Quiz;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import fr.taigaprozz.R;
import fr.taigaprozz.kanjikana.Kana.Kana;
import fr.taigaprozz.kanjikana.MainActivity;


public class Quiz extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        // collect components in layout
        EditText editTextReponseUser = findViewById(R.id.editTextAnswer);
        Button boutonValide = findViewById(R.id.buttonValide);
        Button buttonSkip = findViewById(R.id.buttonSkip);


        // return button arrow
        TextView backArrow = findViewById(R.id.backArrow);
        backArrow.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                finish();
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });

        TextView textViewHiragana = findViewById(R.id.hiragana_lettre_quiz);
        // list of images of hiragana
        String[] hiraganaList = new String[]{
                "あ", "い", "う", "え", "お",
                "か", "き", "く", "け", "こ",
                "さ", "し", "す", "せ", "そ",
                "た", "ち", "つ", "て", "と",
                "な", "に", "ぬ", "ね", "の",
                "は", "ひ", "ふ", "へ", "ほ",
                "ま", "み", "む", "め", "も",
                "や", "ゆ", "よ",
                "ら", "り", "る", "れ", "ろ",
                "わ", "を",
                "ん"

        };

        // en romaji
        String [] hiraganaRomaji = new String[]{
                "a", "i", "u", "e", "o",
                "ka", "ki", "ku", "ke", "ko", "sa", "shi", "su", "se", "so",
                "ta", "chi", "tsu", "te", "to",
                "na", "ni", "nu", "ne", "no",
                "ha", "hi", "fu", "he", "ho",
                "ma", "mi", "mu", "me", "mo",
                "ya", "yu", "yo",
                "ra", "ri", "ru", "re", "ro",
                "wa", "wo",
                "n"
        };

        Random random = new Random();
        int randomNumber = random.nextInt(hiraganaList.length - 1);
        final String[] choiseRandomHiragana = {hiraganaList[randomNumber]};
        final String[] choiseRandomRomaji = {hiraganaRomaji[randomNumber]};
        textViewHiragana.setText(choiseRandomHiragana[0]);


        System.out.println("le romaji aleatoire est :" + choiseRandomRomaji[0]);


        // skip button click listener
        buttonSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random = new Random();
                int randomNumber = random.nextInt(hiraganaList.length - 1);
                choiseRandomHiragana[0] = hiraganaList[randomNumber];
                choiseRandomRomaji[0] = hiraganaRomaji[randomNumber];
                textViewHiragana.setText(choiseRandomHiragana[0]);
            }
        });

        // button validate click listener
        boutonValide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // print in console
                System.out.println("la reponse de l'user :" + editTextReponseUser.getText().toString() + " la bonne reponse : " + choiseRandomRomaji[0]);

                // check if the answer of user is correct
                if (editTextReponseUser.getText().toString().equals(choiseRandomRomaji[0])){
                    Toast.makeText(getApplicationContext(), "Bravo ! La réponse était " + '"' + choiseRandomRomaji[0] + '"', Toast.LENGTH_SHORT).show();
                }
                else{Toast.makeText(getApplicationContext(), "C'est faux ! La bonne réponse était" + '"' + choiseRandomRomaji[0] + '"', Toast.LENGTH_SHORT).show();
                }

            }
        });
    }


    // bouton retour avec bouton du phone
    @Override
    public void onBackPressed() {
        Intent i = new Intent(Quiz.this, MainActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);
        finish();
    }

}