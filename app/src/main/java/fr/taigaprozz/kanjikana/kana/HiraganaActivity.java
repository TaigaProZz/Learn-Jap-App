package fr.taigaprozz.kanjikana.kana;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import fr.taigaprozz.R;
import fr.taigaprozz.kanjikana.main.MainActivity;
import fr.taigaprozz.kanjikana.quiz.SettingsQuiz;


public class HiraganaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hiragana);

        // collect components from layout
        TextView goingBackArrow = findViewById(R.id.goingBackArrow);
        Button buttonSwitchKatakana = findViewById(R.id.button_katakana);
        Button buttonToQuiz = findViewById(R.id.button_quiz);

        // return button at top left
        goingBackArrow.setOnClickListener(v -> {
            finish();
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
        });

        // button page to katakana
        buttonSwitchKatakana.setOnClickListener(v -> {
            finish();
            startActivity(new Intent(getApplicationContext(), KatakanaActivity.class));
        });

        // button page to katakana
        buttonToQuiz.setOnClickListener(v -> {
            finish();
            startActivity(new Intent(getApplicationContext(), SettingsQuiz.class));
        });

        // image list of hiragana
        List<Kana> listKana = new ArrayList<>();
        listKana.add(new Kana(R.drawable.hiragana_a));     listKana.add(new Kana(R.drawable.hiragana_i));     listKana.add(new Kana(R.drawable.hiragana_u));
        listKana.add(new Kana(R.drawable.hiragana_e));     listKana.add(new Kana(R.drawable.hiragana_o));     listKana.add(new Kana(R.drawable.hiragana_ka));
        listKana.add(new Kana(R.drawable.hiragana_ki));    listKana.add(new Kana(R.drawable.hiragana_ku));    listKana.add(new Kana(R.drawable.hiragana_ke));
        listKana.add(new Kana(R.drawable.hiragana_ko));    listKana.add(new Kana(R.drawable.hiragana_sa));    listKana.add(new Kana(R.drawable.hiragana_shi));
        listKana.add(new Kana(R.drawable.hiragana_su));    listKana.add(new Kana(R.drawable.hiragana_se));    listKana.add(new Kana(R.drawable.hiragana_so));
        listKana.add(new Kana(R.drawable.hiragana_ta));    listKana.add(new Kana(R.drawable.hiragana_chi));   listKana.add(new Kana(R.drawable.hiragana_tsu));
        listKana.add(new Kana(R.drawable.hiragana_te));    listKana.add(new Kana(R.drawable.hiragana_to));    listKana.add(new Kana(R.drawable.hiragana_na));
        listKana.add(new Kana(R.drawable.hiragana_ni));    listKana.add(new Kana(R.drawable.hiragana_nu));    listKana.add(new Kana(R.drawable.hiragana_ne));
        listKana.add(new Kana(R.drawable.hiragana_no));    listKana.add(new Kana(R.drawable.hiragana_ha));    listKana.add(new Kana(R.drawable.hiragana_hi));
        listKana.add(new Kana(R.drawable.hiragana_fu));    listKana.add(new Kana(R.drawable.hiragana_he));    listKana.add(new Kana(R.drawable.hiragana_ho));
        listKana.add(new Kana(R.drawable.hiragana_ma));    listKana.add(new Kana(R.drawable.hiragana_mi));    listKana.add(new Kana(R.drawable.hiragana_mu));
        listKana.add(new Kana(R.drawable.hiragana_me));    listKana.add(new Kana(R.drawable.hiragana_mo));    listKana.add(new Kana(R.drawable.hiragana_ya));
        listKana.add(new Kana(0));                         listKana.add(new Kana(R.drawable.hiragana_yu));    listKana.add(new Kana(0));
        listKana.add(new Kana(R.drawable.hiragana_yo));    listKana.add(new Kana(R.drawable.hiragana_ra));    listKana.add(new Kana(R.drawable.hiragana_ri));
        listKana.add(new Kana(R.drawable.hiragana_ru));    listKana.add(new Kana(R.drawable.hiragana_re));    listKana.add(new Kana(R.drawable.hiragana_ro));
        listKana.add(new Kana(R.drawable.hiragana_wa));    listKana.add(new Kana(0));                         listKana.add(new Kana(0));
        listKana.add(new Kana(0));                         listKana.add(new Kana(R.drawable.hiragana_wo));    listKana.add(new Kana(0));
        listKana.add(new Kana(0));                         listKana.add(new Kana(0));                         listKana.add(new Kana(0));
        listKana.add(new Kana(R.drawable.hiragana_n));


        // recycler view params
        RecyclerView recyclerView = findViewById(R.id.hiragana_recyclerview);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        GridLayoutManager manager = new GridLayoutManager(getApplicationContext(), 5, GridLayoutManager.VERTICAL, false);
        manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int arg0) {
                return (arg0 % 10) == 0 ? 1 : 1;
            }
        });
        recyclerView.setLayoutManager(manager);

        // set adapter to recycler view
        KanaAdapter kanaAdapter = new KanaAdapter(listKana);
        recyclerView.setAdapter(kanaAdapter);
    }

    // return button of the phone
    @Override
    public void onBackPressed() {
        finish();
        startActivity(new Intent(getApplicationContext(), MainActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
    }
}