package fr.taigaprozz.kanjikana.quiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import fr.taigaprozz.R
import android.widget.TextView
import android.content.Intent
import android.view.View
import fr.taigaprozz.kanjikana.quiz.SettingsQuiz

class HelpQuiz : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_help_quiz)
        val backArrow = findViewById<TextView>(R.id.goingBackArrow)

//      changeActivityFromText(backArrow, getApplicationContext(), SettingsQuiz);
        backArrow.setOnClickListener {
            finish()
            startActivity(Intent(applicationContext, SettingsQuiz::class.java))
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
    }
}