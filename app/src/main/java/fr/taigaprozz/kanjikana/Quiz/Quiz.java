package fr.taigaprozz.kanjikana.Quiz;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

import fr.taigaprozz.R;
import fr.taigaprozz.kanjikana.Kana.HiraganaActivity;
import fr.taigaprozz.kanjikana.Kana.KatakanaActivity;
import fr.taigaprozz.kanjikana.MainActivity;


public class Quiz extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        // collect components in layout
        EditText editTextReponseUser = findViewById(R.id.editTextAnswer);
        Button validateButton = findViewById(R.id.buttonValidate);
        Button buttonSkip = findViewById(R.id.buttonSkip);
        TextView textViewHiragana = findViewById(R.id.hiragana_lettre_quiz);
        TextView backArrow = findViewById(R.id.goingBackArrow);
        TextView textGoodAnswer = findViewById(R.id.good_answer);
        TextView textWrongAnswer = findViewById(R.id.wrong_answer);
        Button imageHiraganaSwitch = findViewById(R.id.button_hiragana_quiz);
        Button imageKatakanaSwitch = findViewById(R.id.button_katakana_quiz);


        // return button arrow
        backArrow.setOnClickListener(v -> {
                finish();
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
        });

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
                "ん"  };

        // list in latin letter
        String [] latinLetterList = new String[]{
                "a", "i", "u", "e", "o",
                "ka", "ki", "ku", "ke", "ko", "sa", "shi", "su", "se", "so",
                "ta", "chi", "tsu", "te", "to",
                "na", "ni", "nu", "ne", "no",
                "ha", "hi", "fu", "he", "ho",
                "ma", "mi", "mu", "me", "mo",
                "ya", "yu", "yo",
                "ra", "ri", "ru", "re", "ro",
                "wa", "wo",
                "n"  };

        // choose a random hiragana in hiragana list and latin letter list
        Random random = new Random();
        final int[] randomNumber = {random.nextInt(hiraganaList.length - 1)};
        final String[] choiseRandomHiragana = {hiraganaList[randomNumber[0]]};
        final String[] choiseRandomRomaji = {latinLetterList[randomNumber[0]]};
        textViewHiragana.setText(choiseRandomHiragana[0]);

        // button skip is inivisible while button validate is not pressed
        buttonSkip.setVisibility(View.INVISIBLE);
        // set text wrong and good answer to invisible
        textGoodAnswer.setVisibility(View.INVISIBLE);
        textWrongAnswer.setVisibility(View.INVISIBLE);

        // validate button with click listener
        validateButton.setOnClickListener(v -> {
                // print in console
                System.out.println("la reponse de l'user :" + editTextReponseUser.getText().toString() + " la bonne reponse : " + choiseRandomRomaji[0]);

                // check if the text is not empty
                if(editTextReponseUser.getText().length() <=0){
                    Toast.makeText(getApplicationContext(), "Rentres une réponse !", Toast.LENGTH_SHORT).show();
                    return;
                }

                // check if the answer of user is correct
                if (editTextReponseUser.getText().toString().equals(choiseRandomRomaji[0])){
                    // set visibility of good answer to visible
                    textGoodAnswer.setVisibility(View.VISIBLE);

                }
                else {
                    // set visibility of wrong answer to visible
                    textWrongAnswer.setText("Mauvaise réponse ! La réponse était " + choiseRandomRomaji[0]);
                    textWrongAnswer.setVisibility(View.VISIBLE);
                }

                // set the visibility of the skip button to VISIBLE when validate button is pressed
                buttonSkip.setVisibility(View.VISIBLE);
                // and set validate button to invisible
                validateButton.setVisibility(View.INVISIBLE);
                // clear the text of the user when validate button is pressed
                editTextReponseUser.getText().clear();
            });
        // switch to hiragana activity with button
        imageHiraganaSwitch.setOnClickListener(v-> {
            finish();
            startActivity(new Intent(getApplicationContext(), HiraganaActivity.class));
        });

        // switch to katakana activity with button
        imageKatakanaSwitch.setOnClickListener(v -> {
            finish();
            startActivity(new Intent(getApplicationContext(), KatakanaActivity.class));
        });



        // skip button with click listener
        buttonSkip.setOnClickListener(v -> {
            // set visibility to good or wrong answer to invisible
            textGoodAnswer.setVisibility(View.INVISIBLE);
            textWrongAnswer.setVisibility(View.INVISIBLE);
            // choose again a random hiragana
            randomNumber[0] = random.nextInt(hiraganaList.length - 1);
            choiseRandomHiragana[0] = hiraganaList[randomNumber[0]];
            choiseRandomRomaji[0] = latinLetterList[randomNumber[0]];
            textViewHiragana.setText(choiseRandomHiragana[0]);

            // set visibility to the button skip to invisible when pressed and set validate button to visible
            buttonSkip.setVisibility(View.INVISIBLE);
            validateButton.setVisibility(View.VISIBLE);
        });

    }

    // return button of the phone
    @Override
    public void onBackPressed() {
        Intent i = new Intent(Quiz.this, MainActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);
        finish();
    }
}