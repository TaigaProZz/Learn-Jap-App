package fr.taigaprozz.kanjikana.kana

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import fr.taigaprozz.R
import android.widget.TextView
import android.content.Intent
import android.view.View
import android.widget.Button
import fr.taigaprozz.kanjikana.main.MainActivity
import fr.taigaprozz.kanjikana.kana.HiraganaActivity
import fr.taigaprozz.kanjikana.quiz.SettingsQuiz
import fr.taigaprozz.kanjikana.kana.Kana
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
import fr.taigaprozz.kanjikana.GlobalFunctions
import fr.taigaprozz.kanjikana.kana.KanaAdapter
import java.util.ArrayList

class KatakanaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // no animation when activity is changed
        GlobalFunctions.setNoAnimation(this)
        setContentView(R.layout.activity_katakana)

        // collect components from view
        setSupportActionBar(findViewById(R.id.toolbar_katakana))
        val button = findViewById<Button>(R.id.button_hiragana)
        val goingBackArrow = findViewById<TextView>(R.id.goingBackArrow)
        val buttonQuiz = findViewById<Button>(R.id.button_quiz)

        // return button arrow at the top left
        goingBackArrow.setOnClickListener {
            finish()
            startActivity(Intent(applicationContext, MainActivity::class.java))
        }


        // click button switch to hiragana
        button.setOnClickListener {
            finish()
            startActivity(Intent(applicationContext, HiraganaActivity::class.java))
        }
        buttonQuiz.setOnClickListener {
            finish()
            startActivity(Intent(applicationContext, SettingsQuiz::class.java))
        }

        // list image katakana
        val listeKana: MutableList<Kana> = ArrayList()
        listeKana.add(Kana(R.drawable.katakana_a))
        listeKana.add(Kana(R.drawable.katakana_i))
        listeKana.add(Kana(R.drawable.katakana_u))
        listeKana.add(Kana(R.drawable.katakana_e))
        listeKana.add(Kana(R.drawable.katakana_o))
        listeKana.add(Kana(R.drawable.katakana_ka))
        listeKana.add(Kana(R.drawable.katakana_ki))
        listeKana.add(Kana(R.drawable.katakana_ku))
        listeKana.add(Kana(R.drawable.katakana_ke))
        listeKana.add(Kana(R.drawable.katakana_ko))
        listeKana.add(Kana(R.drawable.katakana_sa))
        listeKana.add(Kana(R.drawable.katakana_shi))
        listeKana.add(Kana(R.drawable.katakana_su))
        listeKana.add(Kana(R.drawable.katakana_se))
        listeKana.add(Kana(R.drawable.katakana_so))
        listeKana.add(Kana(R.drawable.katakana_ta))
        listeKana.add(Kana(R.drawable.katakana_chi))
        listeKana.add(Kana(R.drawable.katakana_tsu))
        listeKana.add(Kana(R.drawable.katakana_te))
        listeKana.add(Kana(R.drawable.katakana_to))
        listeKana.add(Kana(R.drawable.katakana_na))
        listeKana.add(Kana(R.drawable.katakana_ni))
        listeKana.add(Kana(R.drawable.katakana_nu))
        listeKana.add(Kana(R.drawable.katakana_ne))
        listeKana.add(Kana(R.drawable.katakana_no))
        listeKana.add(Kana(R.drawable.katakana_ha))
        listeKana.add(Kana(R.drawable.katakana_hi))
        listeKana.add(Kana(R.drawable.katakana_fu))
        listeKana.add(Kana(R.drawable.katakana_he))
        listeKana.add(Kana(R.drawable.katakana_ho))
        listeKana.add(Kana(R.drawable.katakana_ma))
        listeKana.add(Kana(R.drawable.katakana_mi))
        listeKana.add(Kana(R.drawable.katakana_mu))
        listeKana.add(Kana(R.drawable.katakana_me))
        listeKana.add(Kana(R.drawable.katakana_mo))
        listeKana.add(Kana(R.drawable.katakana_ya))
        listeKana.add(Kana(0))
        listeKana.add(Kana(R.drawable.katakana_yu))
        listeKana.add(Kana(0))
        listeKana.add(Kana(R.drawable.katakana_yo))
        listeKana.add(Kana(R.drawable.katakana_ra))
        listeKana.add(Kana(R.drawable.katakana_ri))
        listeKana.add(Kana(R.drawable.katakana_ru))
        listeKana.add(Kana(R.drawable.katakana_re))
        listeKana.add(Kana(R.drawable.katakana_ro))
        listeKana.add(Kana(R.drawable.katakana_wa))
        listeKana.add(Kana(0))
        listeKana.add(Kana(0))
        listeKana.add(Kana(0))
        listeKana.add(Kana(R.drawable.katakana_wo))
        listeKana.add(Kana(0))
        listeKana.add(Kana(0))
        listeKana.add(Kana(0))
        listeKana.add(Kana(0))
        listeKana.add(Kana(R.drawable.katakana_n))

        // recycler view params
        val recyclerView = findViewById<RecyclerView>(R.id.katakana_recyclerview)
        val layoutManager: RecyclerView.LayoutManager
        layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        val manager = GridLayoutManager(applicationContext, 5, GridLayoutManager.VERTICAL, false)
        manager.spanSizeLookup = object : SpanSizeLookup() {
            override fun getSpanSize(arg0: Int): Int {
                return if (arg0 % 4 == 0) 1 else 1
            }
        }
        recyclerView.layoutManager = manager

        // set adapter to recycler view
        val kanaAdapter= KanaAdapter(listeKana)
        recyclerView.adapter = kanaAdapter
    }

}