package fr.taigaprozz.kanjikana.quiz;

import android.annotation.SuppressLint;
import android.content.Intent;
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
import fr.taigaprozz.kanjikana.kana.HiraganaActivity;
import fr.taigaprozz.kanjikana.kana.KatakanaActivity;


public class Quiz extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);


        // collect components in layout
        EditText editTextAnswerUser = findViewById(R.id.editTextAnswer);
        Button validateButton = findViewById(R.id.buttonValidate);
        Button buttonSkip = findViewById(R.id.buttonSkip);
        TextView textViewKana = findViewById(R.id.hiragana_lettre_quiz);
        TextView backArrow = findViewById(R.id.goingBackArrow);
        TextView textGoodAnswer = findViewById(R.id.good_answer);
        TextView textWrongAnswer = findViewById(R.id.wrong_answer);
        Button imageHiraganaSwitch = findViewById(R.id.button_hiragana_quiz);
        Button imageKatakanaSwitch = findViewById(R.id.button_katakana_quiz);
        ImageView imageSettings = findViewById(R.id.settings_level);


        // return button arrow
        backArrow.setOnClickListener(v -> {
            finish();
            startActivity(new Intent(getApplicationContext(), SettingsQuiz.class));
            Levels.getInstance().setLevel_hiragana(0);
            Levels.getInstance().setLevel_katakana(0);
        });

        // list of hiragana
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
                "ん",

                "が", "ぎ", "ぐ", "げ", "ご",
                "ざ", "じ", "ず", "ぜ", "ぞ",
                "だ", "じ", "づ", "で", "ど",
                "ば", "び", "ぶ", "べ", "ぼ",
                "ぱ", "ぴ", "ぷ", "ぺ", "ぽ",

                "きゃ", "きゅ", "きょ",
                "ぎゃ", "ぎゅ", "ぎょ",
                "しゃ", "しゅ", "しょ",
                "じゃ", "じゅ", "じょ",
                "ちゃ", "ちゅ", "ちょ",
                "にゃ", "にゅ", "にょ",
                "ひゃ", "ひゅ", "ひょ",
                "びゃ", "びゅ", "びょ",
                "ぴゃ", "ぴゅ", "ぴょ",
                "みゃ", "みゅ", "みょ",
                "りゃ", "りゅ", "りょ"};

        // list of katakana
        String[] katakanaList = new String[]{
                "ア", "イ", "ウ", "エ", "オ",
                "カ", "キ", "ク", "ケ", "コ",
                "サ", "シ", "ス", "セ", "ソ",
                "タ", "チ", "ツ", "テ", "ト",
                "ナ", "ニ", "ヌ", "ネ", "ノ",
                "ハ", "ヒ", "フ", "ヘ", "ホ",
                "マ", "ミ", "ム", "メ", "モ",
                "ヤ", "ユ", "ヨ",
                "ラ", "リ", "ル", "レ", "ロ",
                "ワ", "ヲ",
                "ン",
                "ガ", "ギ", "グ", "ゲ", "ゴ",
                "ザ", "ジ", "ズ", "ゼ", "ゾ",
                "ダ", "ヂ", "ヅ", "デ", "ド",
                "バ", "ビ", "ブ", "ベ", "ボ",
                "パ", "ピ", "プ", "ペ", "ポ",
                "キャ", "キュ", "キョ",
                "ギャ",	"ギュ", "ギョ",
                "シャ",	"シュ", "ショ",
                "ジャ", "ジュ", "ジョ",
                "チャ", "チュ", "チョ",
                "ニャ",	"ニュ", "ニョ",
                "ヒャ", "ヒュ", "ヒョ",
                "ビャ",	"ビュ", "ビョ",
                "ピャ",	"ピュ", "ピョ",
                "ミャ",	"ミュ", "ミョ",
                "リャ",	"リュ", "リョ"




        };

        // list in latin letter
        String[] latinLetterList = new String[]{
                "a", "i", "u", "e", "o",
                "ka", "ki", "ku", "ke", "ko",
                "sa", "shi", "su", "se", "so",
                "ta", "chi", "tsu", "te", "to",
                "na", "ni", "nu", "ne", "no",
                "ha", "hi", "fu", "he", "ho",
                "ma", "mi", "mu", "me", "mo",
                "ya", "yu", "yo",
                "ra", "ri", "ru", "re", "ro",
                "wa", "wo",
                "n",
                "ga", "gi", "gu", "ge", "go",
                "za", "ji", "zu", "ze", "zo",
                "da", "ji", "zu", "de", "do",
                "ba", "bi", "bu", "be", "bo",
                "pa", "pi", "pu", "pe", "po",
                "kya", "kyu", "kyo",
                "gya", "gyu", "gyo",
                "sha", "shu", "sho",
                "ja", "ju", "jo",
                "cha", "chu", "cho",
                "nya", "nyu", "nyo",
                "hya", "hyu", "hyo",
                "bya", "byu", "byo",
                "pya", "pyu", "pyo",
                "mya", "myu", "myo",
                "rya", "ryu", "ryo"};

        // button skip is invisible while button validate is not pressed
        buttonSkip.setVisibility(View.INVISIBLE);
        // set text wrong and good answer to invisible
        textGoodAnswer.setVisibility(View.INVISIBLE);
        textWrongAnswer.setVisibility(View.INVISIBLE);


        //**********************************  LEVELS FOR HIRAGANA ********************************** \\
        //   *****************                                                    *****************   \\

        // collect the level of the quiz selected by user in SettingsQuiz activity
        int level_hiragana = Levels.getInstance().getLevel_hiragana();
        System.out.println("level" + Levels.getInstance().getLevel_hiragana());


        //   *****************      LEVEL 1      *****************   \\

        if (level_hiragana == 1) {

            // choose a random hiragana in hiragana list and latin letter list
            Random random = new Random();
            final int[] randomNumber = {random.nextInt(hiraganaList.length - 58)};
            final String[] choiseRandomHiraganaLevel1 = {hiraganaList[randomNumber[0]]};
            final String[] choiseRandomRomaji1 = {latinLetterList[randomNumber[0]]};
            textViewKana.setText(choiseRandomHiraganaLevel1[0]);

            // validate button with click listener
            validateButton.setOnClickListener(v -> {

                // check if the text is not empty
                if (editTextAnswerUser.getText().length() <= 0) {
                    Toast.makeText(getApplicationContext(), "Rentres une réponse !", Toast.LENGTH_SHORT).show();
                    return;
                }

                // check if the answer of user is correct
                if (editTextAnswerUser.getText().toString().equals(choiseRandomRomaji1[0])) {
                    // set visibility of good answer to visible
                    textGoodAnswer.setText("Bonne réponse !\n" + '"' + choiseRandomRomaji1[0] + '"' + " est bon");
                    textGoodAnswer.setVisibility(View.VISIBLE);

                } else {
                    // set visibility of wrong answer to visible
                    textWrongAnswer.setText("Mauvaise réponse !\n La réponse était " + '"' + choiseRandomRomaji1[0] + '"');
                    textWrongAnswer.setVisibility(View.VISIBLE);
                }

                // set the visibility of the skip button to VISIBLE when validate button is pressed
                buttonSkip.setVisibility(View.VISIBLE);
                // and set validate button to invisible
                validateButton.setVisibility(View.INVISIBLE);
                // clear the text of the user when validate button is pressed
                editTextAnswerUser.getText().clear();
            });

            // skip button with click listener
            buttonSkip.setOnClickListener(v -> {
                // set visibility to good or wrong answer to invisible
                textGoodAnswer.setVisibility(View.INVISIBLE);
                textWrongAnswer.setVisibility(View.INVISIBLE);
                // choose again a random hiragana
                randomNumber[0] = random.nextInt(hiraganaList.length - 58);
                choiseRandomHiraganaLevel1[0] = hiraganaList[randomNumber[0]];
                choiseRandomRomaji1[0] = latinLetterList[randomNumber[0]];
                textViewKana.setText(choiseRandomHiraganaLevel1[0]);

                // set visibility to the button skip to invisible when pressed and set validate button to visible
                buttonSkip.setVisibility(View.INVISIBLE);
                validateButton.setVisibility(View.VISIBLE);
            });
        }


        //   *****************      LEVEL 2      *****************   \\

        if (level_hiragana == 2) {
            // choose a random hiragana in hiragana list and latin letter list
            Random random2 = new Random();
            final int[] randomNumber2 = {random2.nextInt(hiraganaList.length - 33)};
            final String[] choiseRandomHiraganaLevel2 = {hiraganaList[randomNumber2[0]]};
            final String[] choiseRandomRomaji2 = {latinLetterList[randomNumber2[0]]};
            textViewKana.setText(choiseRandomHiraganaLevel2[0]);

            // validate button with click listener
            validateButton.setOnClickListener(v -> {

                // check if the text is not empty
                if (editTextAnswerUser.getText().length() <= 0) {
                    Toast.makeText(getApplicationContext(), "Rentres une réponse !", Toast.LENGTH_SHORT).show();
                    return;
                }

                // check if the answer of user is correct
                if (editTextAnswerUser.getText().toString().equals(choiseRandomRomaji2[0])) {
                    // set visibility of good answer to visible
                    textGoodAnswer.setText("Bonne réponse !\n " + '"' + choiseRandomRomaji2[0] + '"' + " est bon");

                    textGoodAnswer.setVisibility(View.VISIBLE);

                } else {
                    // set visibility of wrong answer to visible
                    textWrongAnswer.setText("Mauvaise réponse !\n La réponse était " + '"' + choiseRandomRomaji2[0] + '"');
                    textWrongAnswer.setVisibility(View.VISIBLE);
                }

                // set the visibility of the skip button to VISIBLE when validate button is pressed
                buttonSkip.setVisibility(View.VISIBLE);
                // and set validate button to invisible
                validateButton.setVisibility(View.INVISIBLE);
                // clear the text of the user when validate button is pressed
                editTextAnswerUser.getText().clear();
            });

            // skip button with click listener
            buttonSkip.setOnClickListener(v -> {
                // set visibility to good or wrong answer to invisible
                textGoodAnswer.setVisibility(View.INVISIBLE);
                textWrongAnswer.setVisibility(View.INVISIBLE);
                // choose again a random hiragana
                randomNumber2[0] = random2.nextInt(hiraganaList.length - 33);
                choiseRandomHiraganaLevel2[0] = hiraganaList[randomNumber2[0]];
                choiseRandomRomaji2[0] = latinLetterList[randomNumber2[0]];
                textViewKana.setText(choiseRandomHiraganaLevel2[0]);

                // set visibility to the button skip to invisible when pressed and set validate button to visible
                buttonSkip.setVisibility(View.INVISIBLE);
                validateButton.setVisibility(View.VISIBLE);
            });
        }


        //   *****************      LEVEL 3      *****************   \\

        if (level_hiragana == 3) {
            // choose a random hiragana in hiragana list and latin letter list
            Random random3 = new Random();
            final int[] randomNumber3 = {random3.nextInt(hiraganaList.length)};
            final String[] choiseRandomHiraganaLevel3 = {hiraganaList[randomNumber3[0]]};
            final String[] choiseRandomRomaji3 = {latinLetterList[randomNumber3[0]]};
            textViewKana.setText(choiseRandomHiraganaLevel3[0]);

            // validate button with click listener
            validateButton.setOnClickListener(v -> {

                // check if the text is not empty
                if (editTextAnswerUser.getText().length() <= 0) {
                    Toast.makeText(getApplicationContext(), "Rentres une réponse !", Toast.LENGTH_SHORT).show();
                    return;
                }

                // check if the answer of user is correct
                if (editTextAnswerUser.getText().toString().equals(choiseRandomRomaji3[0])) {
                    // set visibility of good answer to visible
                    textGoodAnswer.setText("Bonne réponse !\n " + '"' + choiseRandomRomaji3[0] + '"' + " est bon");
                    textGoodAnswer.setVisibility(View.VISIBLE);

                } else {
                    // set visibility of wrong answer to visible
                    textWrongAnswer.setText("Mauvaise réponse !\n La bonne réponse était " + '"' + choiseRandomRomaji3[0] + '"');
                    textWrongAnswer.setVisibility(View.VISIBLE);
                }

                // set the visibility of the skip button to VISIBLE when validate button is pressed
                buttonSkip.setVisibility(View.VISIBLE);
                // and set validate button to invisible
                validateButton.setVisibility(View.INVISIBLE);
                // clear the text of the user when validate button is pressed
                editTextAnswerUser.getText().clear();
            });

            // skip button with click listener
            buttonSkip.setOnClickListener(v -> {
                // set visibility to good or wrong answer to invisible
                textGoodAnswer.setVisibility(View.INVISIBLE);
                textWrongAnswer.setVisibility(View.INVISIBLE);
                // choose again a random hiragana
                randomNumber3[0] = random3.nextInt(hiraganaList.length);
                choiseRandomHiraganaLevel3[0] = hiraganaList[randomNumber3[0]];
                choiseRandomRomaji3[0] = latinLetterList[randomNumber3[0]];
                textViewKana.setText(choiseRandomHiraganaLevel3[0]);

                // set visibility to the button skip to invisible when pressed and set validate button to visible
                buttonSkip.setVisibility(View.INVISIBLE);
                validateButton.setVisibility(View.VISIBLE);
            });
        }


        //**********************************  LEVELS FOR KATAKANA ********************************** \\
        //   *****************                                                    *****************   \\

        // collect the level of the quiz selected by user in SettingsQuiz activity
        int level_katakana = Levels.getInstance().getLevel_katakana();


        //   *****************      LEVEL 1      *****************   \\

        if (level_katakana == 1) {

            // choose a random hiragana in hiragana list and latin letter list
            Random random = new Random();
            final int[] randomNumber = {random.nextInt(katakanaList.length - 58)};
            final String[] choiseRandomKatakanaLevel1 = {katakanaList[randomNumber[0]]};
            final String[] choiseRandomRomaji1 = {latinLetterList[randomNumber[0]]};
            textViewKana.setText(choiseRandomKatakanaLevel1[0]);

            // validate button with click listener
            validateButton.setOnClickListener(v -> {

                // check if the text is not empty
                if (editTextAnswerUser.getText().length() <= 0) {
                    Toast.makeText(getApplicationContext(), "Rentres une réponse !", Toast.LENGTH_SHORT).show();
                    return;
                }

                // check if the answer of user is correct
                if (editTextAnswerUser.getText().toString().equals(choiseRandomRomaji1[0])) {
                    // set visibility of good answer to visible
                    textGoodAnswer.setText("Bonne réponse !\n" + '"' + choiseRandomRomaji1[0] + '"' + " est bon");
                    textGoodAnswer.setVisibility(View.VISIBLE);

                } else {
                    // set visibility of wrong answer to visible
                    textWrongAnswer.setText("Mauvaise réponse !\n La réponse était " + '"' + choiseRandomRomaji1[0] + '"');
                    textWrongAnswer.setVisibility(View.VISIBLE);
                }

                // set the visibility of the skip button to VISIBLE when validate button is pressed
                buttonSkip.setVisibility(View.VISIBLE);
                // and set validate button to invisible
                validateButton.setVisibility(View.INVISIBLE);
                // clear the text of the user when validate button is pressed
                editTextAnswerUser.getText().clear();
            });

            // skip button with click listener
            buttonSkip.setOnClickListener(v -> {
                // set visibility to good or wrong answer to invisible
                textGoodAnswer.setVisibility(View.INVISIBLE);
                textWrongAnswer.setVisibility(View.INVISIBLE);
                // choose again a random hiragana
                randomNumber[0] = random.nextInt(katakanaList.length - 58);
                choiseRandomKatakanaLevel1[0] = katakanaList[randomNumber[0]];
                choiseRandomRomaji1[0] = latinLetterList[randomNumber[0]];
                textViewKana.setText(choiseRandomKatakanaLevel1[0]);

                // set visibility to the button skip to invisible when pressed and set validate button to visible
                buttonSkip.setVisibility(View.INVISIBLE);
                validateButton.setVisibility(View.VISIBLE);
            });
        }


        //   *****************      LEVEL 2      *****************   \\

        if (level_katakana == 2) {
            // choose a random hiragana in hiragana list and latin letter list
            Random random2 = new Random();
            final int[] randomNumber2 = {random2.nextInt(katakanaList.length - 33)};
            final String[] choiseRandomKatakanaLevel2 = {katakanaList[randomNumber2[0]]};
            final String[] choiseRandomRomaji2 = {latinLetterList[randomNumber2[0]]};
            textViewKana.setText(choiseRandomKatakanaLevel2[0]);

            // validate button with click listener
            validateButton.setOnClickListener(v -> {

                // check if the text is not empty
                if (editTextAnswerUser.getText().length() <= 0) {
                    Toast.makeText(getApplicationContext(), "Rentres une réponse !", Toast.LENGTH_SHORT).show();
                    return;
                }

                // check if the answer of user is correct
                if (editTextAnswerUser.getText().toString().equals(choiseRandomRomaji2[0])) {
                    // set visibility of good answer to visible
                    textGoodAnswer.setText("Bonne réponse !\n " + '"' + choiseRandomRomaji2[0] + '"' + " est bon");

                    textGoodAnswer.setVisibility(View.VISIBLE);

                } else {
                    // set visibility of wrong answer to visible
                    textWrongAnswer.setText("Mauvaise réponse !\n La réponse était " + '"' + choiseRandomRomaji2[0] + '"');
                    textWrongAnswer.setVisibility(View.VISIBLE);
                }

                // set the visibility of the skip button to VISIBLE when validate button is pressed
                buttonSkip.setVisibility(View.VISIBLE);
                // and set validate button to invisible
                validateButton.setVisibility(View.INVISIBLE);
                // clear the text of the user when validate button is pressed
                editTextAnswerUser.getText().clear();
            });

            // skip button with click listener
            buttonSkip.setOnClickListener(v -> {
                // set visibility to good or wrong answer to invisible
                textGoodAnswer.setVisibility(View.INVISIBLE);
                textWrongAnswer.setVisibility(View.INVISIBLE);
                // choose again a random hiragana
                randomNumber2[0] = random2.nextInt(katakanaList.length - 33);
                choiseRandomKatakanaLevel2[0] = katakanaList[randomNumber2[0]];
                choiseRandomRomaji2[0] = latinLetterList[randomNumber2[0]];
                textViewKana.setText(choiseRandomKatakanaLevel2[0]);

                // set visibility to the button skip to invisible when pressed and set validate button to visible
                buttonSkip.setVisibility(View.INVISIBLE);
                validateButton.setVisibility(View.VISIBLE);
            });
        }


        //   *****************      LEVEL 3      *****************   \\

        if (level_katakana == 3) {
            // choose a random hiragana in hiragana list and latin letter list
            Random random3 = new Random();
            final int[] randomNumber3 = {random3.nextInt(katakanaList.length)};
            final String[] choiseRandomKatakanaLevel3 = {katakanaList[randomNumber3[0]]};
            final String[] choiseRandomRomaji3 = {latinLetterList[randomNumber3[0]]};
            textViewKana.setText(choiseRandomKatakanaLevel3[0]);

            // validate button with click listener
            validateButton.setOnClickListener(v -> {

                // check if the text is not empty
                if (editTextAnswerUser.getText().length() <= 0) {
                    Toast.makeText(getApplicationContext(), "Rentres une réponse !", Toast.LENGTH_SHORT).show();
                    return;
                }

                // check if the answer of user is correct
                if (editTextAnswerUser.getText().toString().equals(choiseRandomRomaji3[0])) {
                    // set visibility of good answer to visible
                    textGoodAnswer.setText("Bonne réponse !\n " + '"' + choiseRandomRomaji3[0] + '"' + " est bon");
                    textGoodAnswer.setVisibility(View.VISIBLE);

                } else {
                    // set visibility of wrong answer to visible
                    textWrongAnswer.setText("Mauvaise réponse !\n La bonne réponse était " + '"' + choiseRandomRomaji3[0] + '"');
                    textWrongAnswer.setVisibility(View.VISIBLE);
                }

                // set the visibility of the skip button to VISIBLE when validate button is pressed
                buttonSkip.setVisibility(View.VISIBLE);
                // and set validate button to invisible
                validateButton.setVisibility(View.INVISIBLE);
                // clear the text of the user when validate button is pressed
                editTextAnswerUser.getText().clear();
            });

            // skip button with click listener
            buttonSkip.setOnClickListener(v -> {
                // set visibility to good or wrong answer to invisible
                textGoodAnswer.setVisibility(View.INVISIBLE);
                textWrongAnswer.setVisibility(View.INVISIBLE);
                // choose again a random hiragana
                randomNumber3[0] = random3.nextInt(katakanaList.length);
                choiseRandomKatakanaLevel3[0] = katakanaList[randomNumber3[0]];
                choiseRandomRomaji3[0] = latinLetterList[randomNumber3[0]];
                textViewKana.setText(choiseRandomKatakanaLevel3[0]);

                // set visibility to the button skip to invisible when pressed and set validate button to visible
                buttonSkip.setVisibility(View.INVISIBLE);
                validateButton.setVisibility(View.VISIBLE);
            });
        }

        // switch to hiragana activity with button
        imageHiraganaSwitch.setOnClickListener(v -> {
            finish();
            startActivity(new Intent(getApplicationContext(), HiraganaActivity.class));
        });

        // switch to katakana activity with button
        imageKatakanaSwitch.setOnClickListener(v -> {
            finish();
            startActivity(new Intent(getApplicationContext(), KatakanaActivity.class));
        });

        imageSettings.setOnClickListener(v -> {
            finish();
            startActivity(new Intent(getApplicationContext(), SettingsQuiz.class));
            Levels.getInstance().setLevel_hiragana(0);
            Levels.getInstance().setLevel_katakana(0);
        });
    }


    // return button of the phone
    @Override
    public void onBackPressed() {
        finish();
        startActivity(new Intent(getApplicationContext(), SettingsQuiz.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
        Levels.getInstance().setLevel_hiragana(0);
        Levels.getInstance().setLevel_katakana(0);
    }
}