package fr.taigaprozz.kanjikana.main

import android.content.Intent
import android.content.res.Resources
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import fr.taigaprozz.R
import fr.taigaprozz.kanjikana.kana.HiraganaActivity
import fr.taigaprozz.kanjikana.kana.KatakanaActivity
import fr.taigaprozz.kanjikana.quiz.SettingsQuiz
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        // start hiragana activity with the button
        val hiraganaActivityImageMain = findViewById<TextView>(R.id.hiragana_button)
        hiraganaActivityImageMain.setOnClickListener { v: View? ->
            finish()
            startActivity(Intent(applicationContext, HiraganaActivity::class.java))
        }

        // start katakana activity with the button
        val katakanaActivityMainImage = findViewById<TextView>(R.id.katakana_button)
        katakanaActivityMainImage.setOnClickListener { v: View? ->
            finish()
            startActivity(Intent(applicationContext, KatakanaActivity::class.java))
        }

        // start quiz activity with the button
        val quizActivityMainImage = findViewById<TextView>(R.id.quiz_start)
        quizActivityMainImage.setOnClickListener { v: View? ->
            finish()
            startActivity(Intent(applicationContext, SettingsQuiz::class.java))
        }
        val settingsApp = findViewById<ImageView>(R.id.settings_app)
        settingsApp.setOnClickListener { v: View? ->
            finish()
            startActivity(Intent(applicationContext, SettingsActivity::class.java))
        }
    }
}