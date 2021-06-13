package fr.taigaprozz.kanjikana.main

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import fr.taigaprozz.R
import fr.taigaprozz.kanjikana.GlobalFunctions
import fr.taigaprozz.kanjikana.kana.HiraganaActivity
import fr.taigaprozz.kanjikana.kana.KatakanaActivity
import fr.taigaprozz.kanjikana.quiz.SettingsQuiz

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // no animation when activity is changed
        GlobalFunctions.setNoAnimation(this)
        setContentView(R.layout.activity_main)




        findViewById<Button>(R.id.theme_button).setOnClickListener {
            AppCompatDelegate.MODE_NIGHT_YES
        }


        // start hiragana activity with the button
        findViewById<TextView>(R.id.hiragana_button).setOnClickListener {
            startActivity(Intent(applicationContext, HiraganaActivity::class.java))
        }

        // start katakana activity with the button

        findViewById<TextView>(R.id.katakana_button).setOnClickListener{
            startActivity(Intent(applicationContext, KatakanaActivity::class.java))
        }


        // start quiz activity

        findViewById<TextView>(R.id.quiz_start).setOnClickListener{
            startActivity(Intent(applicationContext, SettingsQuiz::class.java))
        }

        // start settings apps
        findViewById<ImageView>(R.id.settings_app).setOnClickListener {
            startActivity(Intent(applicationContext, SettingsActivity::class.java))
        }
    }


}