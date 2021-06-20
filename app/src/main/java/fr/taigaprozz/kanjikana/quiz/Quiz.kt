package fr.taigaprozz.kanjikana.quiz

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import fr.taigaprozz.R
import fr.taigaprozz.kanjikana.GlobalFunctions
import fr.taigaprozz.kanjikana.kana.HiraganaActivity
import fr.taigaprozz.kanjikana.kana.KatakanaActivity
import java.util.*

class Quiz : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // no animation when activity is changed
        GlobalFunctions.setNoAnimation(this)
        setContentView(R.layout.activity_quiz)


        // collect components in layout
        val editTextAnswerUser = findViewById<EditText>(R.id.editTextAnswer)
        val validateButton = findViewById<Button>(R.id.buttonValidate)
        val buttonSkip = findViewById<Button>(R.id.buttonSkip)
        val textViewKana = findViewById<TextView>(R.id.hiragana_lettre_quiz)
        val backArrow = findViewById<TextView>(R.id.goingBackArrow)
        val textGoodAnswer = findViewById<TextView>(R.id.good_answer)
        val textWrongAnswer = findViewById<TextView>(R.id.wrong_answer)
        val imageHiraganaSwitch = findViewById<Button>(R.id.button_hiragana_quiz)
        val imageKatakanaSwitch = findViewById<Button>(R.id.button_katakana_quiz)
        val imageSettings = findViewById<ImageView>(R.id.settings_level)


        // return button arrow
        backArrow.setOnClickListener { v: View? ->
            finish()
            startActivity(Intent(applicationContext, SettingsQuiz::class.java))
            Levels.getInstance().levelHiragana = 0
            Levels.getInstance().levelKatakana = 0
        }

        // list of hiragana
        val hiraganaList = arrayOf(
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
            "りゃ", "りゅ", "りょ"
        )

        // list of katakana
        val katakanaList = arrayOf(
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
            "ギャ", "ギュ", "ギョ",
            "シャ", "シュ", "ショ",
            "ジャ", "ジュ", "ジョ",
            "チャ", "チュ", "チョ",
            "ニャ", "ニュ", "ニョ",
            "ヒャ", "ヒュ", "ヒョ",
            "ビャ", "ビュ", "ビョ",
            "ピャ", "ピュ", "ピョ",
            "ミャ", "ミュ", "ミョ",
            "リャ", "リュ", "リョ"
        )

        // list in latin letter
        val latinLetterList = arrayOf(
            "a", "i", "u", "e", "o",  // 5
            "ka", "ki", "ku", "ke", "ko",  // 10
            "sa", "shi", "su", "se", "so",  // 15
            "ta", "chi", "tsu", "te", "to",  // 20
            "na", "ni", "nu", "ne", "no",  // 25
            "ha", "hi", "fu", "he", "ho",  // 30
            "ma", "mi", "mu", "me", "mo",  // 35
            "ya", "yu", "yo",  // 38
            "ra", "ri", "ru", "re", "ro",  // 43
            "wa", "wo",  // 45
            "n",  // 46
            "ga", "gi", "gu", "ge", "go",  // 51
            "za", "ji", "zu", "ze", "zo",  // 56
            "da", "ji", "zu", "de", "do",  // 61
            "ba", "bi", "bu", "be", "bo",  // 66
            "pa", "pi", "pu", "pe", "po",  // 71
            "kya", "kyu", "kyo",  // 74
            "gya", "gyu", "gyo",  // 77
            "sha", "shu", "sho",  // 80
            "ja", "ju", "jo",  // 83
            "cha", "chu", "cho",  // 86
            "nya", "nyu", "nyo",  // 89
            "hya", "hyu", "hyo",  // 92
            "bya", "byu", "byo",  // 95
            "pya", "pyu", "pyo",  // 98
            "mya", "myu", "myo",  // 101
            "rya", "ryu", "ryo"
        ) // 104

        // button skip is invisible while button validate is not pressed
        buttonSkip.visibility = View.INVISIBLE
        // set text wrong and good answer to invisible
        textGoodAnswer.visibility = View.INVISIBLE
        textWrongAnswer.visibility = View.INVISIBLE


        //**********************************  LEVELS FOR HIRAGANA ********************************** \\
        //   *****************                                                    *****************   \\

        // collect the level of the quiz selected by user in SettingsQuiz activity
        val level_hiragana = Levels.getInstance().levelHiragana


        //   *****************      LEVEL 1      *****************   \\
        if (level_hiragana == 1) {

            // choose a random hiragana in hiragana list and latin letter list
            val random = Random()
            val randomNumber = intArrayOf(random.nextInt(hiraganaList.size - 58))
            val choseRandomHiraganaLevel1 = arrayOf(hiraganaList[randomNumber[0]])
            val choseRandomRomaji1 = arrayOf(latinLetterList[randomNumber[0]])
            textViewKana.text = choseRandomHiraganaLevel1[0]

            // validate button with click listener
            validateButton.setOnClickListener { v: View? ->

                // check if the text is not empty
                if (editTextAnswerUser.text.length <= 0) {
                    Toast.makeText(applicationContext, "Rentres une réponse !", Toast.LENGTH_SHORT)
                        .show()
                    return@setOnClickListener
                }

                // check if the answer of user is correct
                if (editTextAnswerUser.text.toString() == choseRandomRomaji1[0]) {
                    // set visibility of good answer to visible
                    textGoodAnswer.text = """Bonne réponse! "${choseRandomRomaji1[0]}" est bon"""
                    textGoodAnswer.visibility = View.VISIBLE
                } else {
                    // set visibility of wrong answer to visible
                    textWrongAnswer.text = """Mauvaise réponse! La réponse était "${choseRandomRomaji1[0]}""""
                    textWrongAnswer.visibility = View.VISIBLE
                }

                // set the visibility of the skip button to VISIBLE when validate button is pressed
                buttonSkip.visibility = View.VISIBLE
                // and set validate button to invisible
                validateButton.visibility = View.INVISIBLE
                // clear the text of the user when validate button is pressed
                editTextAnswerUser.text.clear()
            }

            // skip button with click listener
            buttonSkip.setOnClickListener { v: View? ->
                // set visibility to good or wrong answer to invisible
                textGoodAnswer.visibility = View.INVISIBLE
                textWrongAnswer.visibility = View.INVISIBLE
                // choose again a random hiragana
                randomNumber[0] = random.nextInt(hiraganaList.size - 58)
                choseRandomHiraganaLevel1[0] = hiraganaList[randomNumber[0]]
                choseRandomRomaji1[0] = latinLetterList[randomNumber[0]]
                textViewKana.text = choseRandomHiraganaLevel1[0]

                // set visibility to the button skip to invisible when pressed and set validate button to visible
                buttonSkip.visibility = View.INVISIBLE
                validateButton.visibility = View.VISIBLE
            }
        }


        //   *****************      LEVEL 2      *****************   \\
        if (level_hiragana == 2) {
            // choose a random hiragana in hiragana list and latin letter list
            val random2 = Random()
            val randomNumber2 = intArrayOf(random2.nextInt(hiraganaList.size - 33))
            val choiseRandomHiraganaLevel2 = arrayOf(hiraganaList[randomNumber2[0]])
            val choiseRandomRomaji2 = arrayOf(latinLetterList[randomNumber2[0]])
            textViewKana.text = choiseRandomHiraganaLevel2[0]

            // validate button with click listener
            validateButton.setOnClickListener { v: View? ->

                // check if the text is not empty
                if (editTextAnswerUser.text.length <= 0) {
                    Toast.makeText(applicationContext, "Rentres une réponse !", Toast.LENGTH_SHORT)
                        .show()
                    return@setOnClickListener
                }

                // check if the answer of user is correct
                if (editTextAnswerUser.text.toString() == choiseRandomRomaji2[0]) {
                    // set visibility of good answer to visible
                    textGoodAnswer.text = """Bonne réponse !
 "${choiseRandomRomaji2[0]}" est bon"""
                    textGoodAnswer.visibility = View.VISIBLE
                } else {
                    // set visibility of wrong answer to visible
                    textWrongAnswer.text = """Mauvaise réponse !
 La réponse était "${choiseRandomRomaji2[0]}""""
                    textWrongAnswer.visibility = View.VISIBLE
                }

                // set the visibility of the skip button to VISIBLE when validate button is pressed
                buttonSkip.visibility = View.VISIBLE
                // and set validate button to invisible
                validateButton.visibility = View.INVISIBLE
                // clear the text of the user when validate button is pressed
                editTextAnswerUser.text.clear()
            }

            // skip button with click listener
            buttonSkip.setOnClickListener { v: View? ->
                // set visibility to good or wrong answer to invisible
                textGoodAnswer.visibility = View.INVISIBLE
                textWrongAnswer.visibility = View.INVISIBLE
                // choose again a random hiragana
                randomNumber2[0] = random2.nextInt(hiraganaList.size - 33)
                choiseRandomHiraganaLevel2[0] = hiraganaList[randomNumber2[0]]
                choiseRandomRomaji2[0] = latinLetterList[randomNumber2[0]]
                textViewKana.text = choiseRandomHiraganaLevel2[0]

                // set visibility to the button skip to invisible when pressed and set validate button to visible
                buttonSkip.visibility = View.INVISIBLE
                validateButton.visibility = View.VISIBLE
            }
        }


        //   *****************      LEVEL 3      *****************   \\
        if (level_hiragana == 3) {
            // choose a random hiragana in hiragana list and latin letter list
            val random3 = Random()
            val randomNumber3 = intArrayOf(random3.nextInt(hiraganaList.size))
            val choiseRandomHiraganaLevel3 = arrayOf(hiraganaList[randomNumber3[0]])
            val choiseRandomRomaji3 = arrayOf(latinLetterList[randomNumber3[0]])
            textViewKana.text = choiseRandomHiraganaLevel3[0]

            // validate button with click listener
            validateButton.setOnClickListener { v: View? ->

                // check if the text is not empty
                if (editTextAnswerUser.text.length <= 0) {
                    Toast.makeText(applicationContext, "Rentres une réponse !", Toast.LENGTH_SHORT)
                        .show()
                    return@setOnClickListener
                }

                // check if the answer of user is correct
                if (editTextAnswerUser.text.toString() == choiseRandomRomaji3[0]) {
                    // set visibility of good answer to visible
                    textGoodAnswer.text = """Bonne réponse !
 "${choiseRandomRomaji3[0]}" est bon"""
                    textGoodAnswer.visibility = View.VISIBLE
                } else {
                    // set visibility of wrong answer to visible
                    textWrongAnswer.text = """Mauvaise réponse !
 La bonne réponse était "${choiseRandomRomaji3[0]}""""
                    textWrongAnswer.visibility = View.VISIBLE
                }

                // set the visibility of the skip button to VISIBLE when validate button is pressed
                buttonSkip.visibility = View.VISIBLE
                // and set validate button to invisible
                validateButton.visibility = View.INVISIBLE
                // clear the text of the user when validate button is pressed
                editTextAnswerUser.text.clear()
            }

            // skip button with click listener
            buttonSkip.setOnClickListener { v: View? ->
                // set visibility to good or wrong answer to invisible
                textGoodAnswer.visibility = View.INVISIBLE
                textWrongAnswer.visibility = View.INVISIBLE
                // choose again a random hiragana
                randomNumber3[0] = random3.nextInt(hiraganaList.size)
                choiseRandomHiraganaLevel3[0] = hiraganaList[randomNumber3[0]]
                choiseRandomRomaji3[0] = latinLetterList[randomNumber3[0]]
                textViewKana.text = choiseRandomHiraganaLevel3[0]

                // set visibility to the button skip to invisible when pressed and set validate button to visible
                buttonSkip.visibility = View.INVISIBLE
                validateButton.visibility = View.VISIBLE
            }
        }


        //**********************************  LEVELS FOR KATAKANA ********************************** \\
        //   *****************                                                    *****************   \\

        // collect the level of the quiz selected by user in SettingsQuiz activity
        val level_katakana = Levels.getInstance().levelKatakana


        //   *****************      LEVEL 1      *****************   \\
        if (level_katakana == 1) {

            // choose a random hiragana in hiragana list and latin letter list
            val random = Random()
            val randomNumber = intArrayOf(random.nextInt(katakanaList.size - 58))
            val choiseRandomKatakanaLevel1 = arrayOf(katakanaList[randomNumber[0]])
            val choiseRandomRomaji1 = arrayOf(latinLetterList[randomNumber[0]])
            textViewKana.text = choiseRandomKatakanaLevel1[0]

            // validate button with click listener
            validateButton.setOnClickListener { v: View? ->

                // check if the text is not empty
                if (editTextAnswerUser.text.length <= 0) {
                    Toast.makeText(applicationContext, "Rentres une réponse !", Toast.LENGTH_SHORT)
                        .show()
                    return@setOnClickListener
                }

                // check if the answer of user is correct
                if (editTextAnswerUser.text.toString() == choiseRandomRomaji1[0]) {
                    // set visibility of good answer to visible
                    textGoodAnswer.text = """Bonne réponse !
"${choiseRandomRomaji1[0]}" est bon"""
                    textGoodAnswer.visibility = View.VISIBLE
                } else {
                    // set visibility of wrong answer to visible
                    textWrongAnswer.text = """Mauvaise réponse !
 La réponse était "${choiseRandomRomaji1[0]}""""
                    textWrongAnswer.visibility = View.VISIBLE
                }

                // set the visibility of the skip button to VISIBLE when validate button is pressed
                buttonSkip.visibility = View.VISIBLE
                // and set validate button to invisible
                validateButton.visibility = View.INVISIBLE
                // clear the text of the user when validate button is pressed
                editTextAnswerUser.text.clear()
            }

            // skip button with click listener
            buttonSkip.setOnClickListener { v: View? ->
                // set visibility to good or wrong answer to invisible
                textGoodAnswer.visibility = View.INVISIBLE
                textWrongAnswer.visibility = View.INVISIBLE
                // choose again a random hiragana
                randomNumber[0] = random.nextInt(katakanaList.size - 58)
                choiseRandomKatakanaLevel1[0] = katakanaList[randomNumber[0]]
                choiseRandomRomaji1[0] = latinLetterList[randomNumber[0]]
                textViewKana.text = choiseRandomKatakanaLevel1[0]

                // set visibility to the button skip to invisible when pressed and set validate button to visible
                buttonSkip.visibility = View.INVISIBLE
                validateButton.visibility = View.VISIBLE
            }
        }


        //   *****************      LEVEL 2      *****************   \\
        if (level_katakana == 2) {
            // choose a random hiragana in hiragana list and latin letter list
            val random2 = Random()
            val randomNumber2 = intArrayOf(random2.nextInt(katakanaList.size - 33))
            val choiseRandomKatakanaLevel2 = arrayOf(katakanaList[randomNumber2[0]])
            val choiseRandomRomaji2 = arrayOf(latinLetterList[randomNumber2[0]])
            textViewKana.text = choiseRandomKatakanaLevel2[0]

            // validate button with click listener
            validateButton.setOnClickListener { v: View? ->

                // check if the text is not empty
                if (editTextAnswerUser.text.length <= 0) {
                    Toast.makeText(applicationContext, "Rentres une réponse !", Toast.LENGTH_SHORT)
                        .show()
                    return@setOnClickListener
                }

                // check if the answer of user is correct
                if (editTextAnswerUser.text.toString() == choiseRandomRomaji2[0]) {
                    // set visibility of good answer to visible
                    textGoodAnswer.text = """Bonne réponse !
 "${choiseRandomRomaji2[0]}" est bon"""
                    textGoodAnswer.visibility = View.VISIBLE
                } else {
                    // set visibility of wrong answer to visible
                    textWrongAnswer.text = """Mauvaise réponse !
 La réponse était "${choiseRandomRomaji2[0]}""""
                    textWrongAnswer.visibility = View.VISIBLE
                }

                // set the visibility of the skip button to VISIBLE when validate button is pressed
                buttonSkip.visibility = View.VISIBLE
                // and set validate button to invisible
                validateButton.visibility = View.INVISIBLE
                // clear the text of the user when validate button is pressed
                editTextAnswerUser.text.clear()
            }

            // skip button with click listener
            buttonSkip.setOnClickListener { v: View? ->
                // set visibility to good or wrong answer to invisible
                textGoodAnswer.visibility = View.INVISIBLE
                textWrongAnswer.visibility = View.INVISIBLE
                // choose again a random hiragana
                randomNumber2[0] = random2.nextInt(katakanaList.size - 33)
                choiseRandomKatakanaLevel2[0] = katakanaList[randomNumber2[0]]
                choiseRandomRomaji2[0] = latinLetterList[randomNumber2[0]]
                textViewKana.text = choiseRandomKatakanaLevel2[0]

                // set visibility to the button skip to invisible when pressed and set validate button to visible
                buttonSkip.visibility = View.INVISIBLE
                validateButton.visibility = View.VISIBLE
            }
        }


        //   *****************      LEVEL 3      *****************   \\
        if (level_katakana == 3) {
            // choose a random hiragana in hiragana list and latin letter list
            val random3 = Random()
            val randomNumber3 = intArrayOf(random3.nextInt(katakanaList.size))
            val choiseRandomKatakanaLevel3 = arrayOf(katakanaList[randomNumber3[0]])
            val choiseRandomRomaji3 = arrayOf(latinLetterList[randomNumber3[0]])
            textViewKana.text = choiseRandomKatakanaLevel3[0]

            // validate button with click listener
            validateButton.setOnClickListener { v: View? ->

                // check if the text is not empty
                if (editTextAnswerUser.text.length <= 0) {
                    Toast.makeText(applicationContext, "Rentres une réponse !", Toast.LENGTH_SHORT)
                        .show()
                    return@setOnClickListener
                }

                // check if the answer of user is correct
                if (editTextAnswerUser.text.toString() == choiseRandomRomaji3[0]) {
                    // set visibility of good answer to visible
                    textGoodAnswer.text = """Bonne réponse !
 "${choiseRandomRomaji3[0]}" est bon"""
                    textGoodAnswer.visibility = View.VISIBLE
                } else {
                    // set visibility of wrong answer to visible
                    textWrongAnswer.text = """Mauvaise réponse !
 La bonne réponse était "${choiseRandomRomaji3[0]}""""
                    textWrongAnswer.visibility = View.VISIBLE
                }

                // set the visibility of the skip button to VISIBLE when validate button is pressed
                buttonSkip.visibility = View.VISIBLE
                // and set validate button to invisible
                validateButton.visibility = View.INVISIBLE
                // clear the text of the user when validate button is pressed
                editTextAnswerUser.text.clear()
            }

            // skip button with click listener
            buttonSkip.setOnClickListener { v: View? ->
                // set visibility to good or wrong answer to invisible
                textGoodAnswer.visibility = View.INVISIBLE
                textWrongAnswer.visibility = View.INVISIBLE
                // choose again a random hiragana
                randomNumber3[0] = random3.nextInt(katakanaList.size)
                choiseRandomKatakanaLevel3[0] = katakanaList[randomNumber3[0]]
                choiseRandomRomaji3[0] = latinLetterList[randomNumber3[0]]
                textViewKana.text = choiseRandomKatakanaLevel3[0]

                // set visibility to the button skip to invisible when pressed and set validate button to visible
                buttonSkip.visibility = View.INVISIBLE
                validateButton.visibility = View.VISIBLE
            }
        }

        // switch to hiragana activity with button
        imageHiraganaSwitch.setOnClickListener { v: View? ->
            finish()
            startActivity(Intent(applicationContext, HiraganaActivity::class.java))
        }

        // switch to katakana activity with button
        imageKatakanaSwitch.setOnClickListener { v: View? ->
            finish()
            startActivity(Intent(applicationContext, KatakanaActivity::class.java))
        }
        imageSettings.setOnClickListener { v: View? ->
            finish()
            startActivity(Intent(applicationContext, SettingsQuiz::class.java))
            Levels.getInstance().levelHiragana = 0
            Levels.getInstance().levelKatakana = 0
        }
    }

    // return button of the phone
    override fun onBackPressed() {
        finish()
        startActivity(
            Intent(
                applicationContext,
                SettingsQuiz::class.java
            ).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        )
        Levels.getInstance().levelHiragana = 0
        Levels.getInstance().levelKatakana = 0
    }
}