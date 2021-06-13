package fr.taigaprozz.kanjikana.kana

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import fr.taigaprozz.R
import fr.taigaprozz.kanjikana.GlobalFunctions.setNoAnimation
import fr.taigaprozz.kanjikana.main.MainActivity
import fr.taigaprozz.kanjikana.quiz.SettingsQuiz
import java.util.*

class HiraganaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // no animation when activity is changed
        setNoAnimation(this)
        setContentView(R.layout.activity_hiragana)

        // collect components from layout
        val goingBackArrow = findViewById<TextView>(R.id.goingBackArrow)
        val buttonSwitchKatakana = findViewById<Button>(R.id.button_katakana)
        val buttonToQuiz = findViewById<Button>(R.id.button_quiz)

        // return button at top left
        goingBackArrow.setOnClickListener { v: View? ->
            finish()
            startActivity(Intent(applicationContext, MainActivity::class.java))
        }

        // button page to katakana
        buttonSwitchKatakana.setOnClickListener { v: View? ->
            finish()
            startActivity(Intent(applicationContext, KatakanaActivity::class.java))
        }

        // button page to katakana
        buttonToQuiz.setOnClickListener { v: View? ->
            finish()
            startActivity(Intent(applicationContext, SettingsQuiz::class.java))
        }

        // image list of hiragana
        val listKana: MutableList<Kana> = ArrayList()
        listKana.add(Kana(R.drawable.hiragana_a))
        listKana.add(Kana(R.drawable.hiragana_i))
        listKana.add(Kana(R.drawable.hiragana_u))
        listKana.add(Kana(R.drawable.hiragana_e))
        listKana.add(Kana(R.drawable.hiragana_o))
        listKana.add(Kana(R.drawable.hiragana_ka))
        listKana.add(Kana(R.drawable.hiragana_ki))
        listKana.add(Kana(R.drawable.hiragana_ku))
        listKana.add(Kana(R.drawable.hiragana_ke))
        listKana.add(Kana(R.drawable.hiragana_ko))
        listKana.add(Kana(R.drawable.hiragana_sa))
        listKana.add(Kana(R.drawable.hiragana_shi))
        listKana.add(Kana(R.drawable.hiragana_su))
        listKana.add(Kana(R.drawable.hiragana_se))
        listKana.add(Kana(R.drawable.hiragana_so))
        listKana.add(Kana(R.drawable.hiragana_ta))
        listKana.add(Kana(R.drawable.hiragana_chi))
        listKana.add(Kana(R.drawable.hiragana_tsu))
        listKana.add(Kana(R.drawable.hiragana_te))
        listKana.add(Kana(R.drawable.hiragana_to))
        listKana.add(Kana(R.drawable.hiragana_na))
        listKana.add(Kana(R.drawable.hiragana_ni))
        listKana.add(Kana(R.drawable.hiragana_nu))
        listKana.add(Kana(R.drawable.hiragana_ne))
        listKana.add(Kana(R.drawable.hiragana_no))
        listKana.add(Kana(R.drawable.hiragana_ha))
        listKana.add(Kana(R.drawable.hiragana_hi))
        listKana.add(Kana(R.drawable.hiragana_fu))
        listKana.add(Kana(R.drawable.hiragana_he))
        listKana.add(Kana(R.drawable.hiragana_ho))
        listKana.add(Kana(R.drawable.hiragana_ma))
        listKana.add(Kana(R.drawable.hiragana_mi))
        listKana.add(Kana(R.drawable.hiragana_mu))
        listKana.add(Kana(R.drawable.hiragana_me))
        listKana.add(Kana(R.drawable.hiragana_mo))
        listKana.add(Kana(R.drawable.hiragana_ya))
        listKana.add(Kana(0))
        listKana.add(Kana(R.drawable.hiragana_yu))
        listKana.add(Kana(0))
        listKana.add(Kana(R.drawable.hiragana_yo))
        listKana.add(Kana(R.drawable.hiragana_ra))
        listKana.add(Kana(R.drawable.hiragana_ri))
        listKana.add(Kana(R.drawable.hiragana_ru))
        listKana.add(Kana(R.drawable.hiragana_re))
        listKana.add(Kana(R.drawable.hiragana_ro))
        listKana.add(Kana(R.drawable.hiragana_wa))
        listKana.add(Kana(0))
        listKana.add(Kana(0))
        listKana.add(Kana(0))
        listKana.add(Kana(R.drawable.hiragana_wo))
        listKana.add(Kana(0))
        listKana.add(Kana(0))
        listKana.add(Kana(0))
        listKana.add(Kana(0))
        listKana.add(Kana(R.drawable.hiragana_n))


        // recycler view params
        val recyclerView = findViewById<RecyclerView>(R.id.hiragana_recyclerview)
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        val manager = GridLayoutManager(applicationContext, 5, GridLayoutManager.VERTICAL, false)
        manager.spanSizeLookup = object : SpanSizeLookup() {
            override fun getSpanSize(arg0: Int): Int {
                return if (arg0 % 10 == 0) 1 else 1
            }
        }
        recyclerView.layoutManager = manager

        // set adapter to recycler view
        val kanaAdapter = KanaAdapter(listKana)
        recyclerView.adapter = kanaAdapter
    }


}