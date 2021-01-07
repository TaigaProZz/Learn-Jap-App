package fr.taigaprozz.kanjikana.Kana;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import fr.taigaprozz.R;
import fr.taigaprozz.kanjikana.Kanji.KanjiActivity;
import fr.taigaprozz.kanjikana.MainActivity;


public class HiraganaActivity extends AppCompatActivity {

    public Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_hiragana);



        // bouton retour en haut a gauche

        TextView retour_arriere = findViewById (R.id.retour_arriere);
        retour_arriere.setOnClickListener (v -> {
            Intent otherActivity3 = new Intent (getApplicationContext (), MainActivity.class);
            startActivity (otherActivity3);
            finish ();

        });


        // bouton page katakana

        Button button = findViewById (R.id.button_katakana);
        button.setOnClickListener(v -> {
            Intent otherActivity = new Intent(getApplicationContext (), KatakanaActivity.class);
            startActivity (otherActivity);
            finish ();
        });


        // liste

        List<Kana> listeKana = new ArrayList<>();
        listeKana.add(new Kana (R.drawable.hiragana_a));
        listeKana.add(new Kana (R.drawable.hiragana_i));
        listeKana.add(new Kana (R.drawable.hiragana_u));
        listeKana.add(new Kana (R.drawable.hiragana_e));
        listeKana.add(new Kana (R.drawable.hiragana_o));
        listeKana.add(new Kana (R.drawable.hiragana_ka));
        listeKana.add(new Kana (R.drawable.hiragana_ki));
        listeKana.add(new Kana (R.drawable.hiragana_ku));
        listeKana.add(new Kana (R.drawable.hiragana_ke));
        listeKana.add(new Kana (R.drawable.hiragana_ko));
        listeKana.add(new Kana (R.drawable.hiragana_sa));
        listeKana.add(new Kana (R.drawable.hiragana_shi));
        listeKana.add(new Kana (R.drawable.hiragana_su));
        listeKana.add(new Kana (R.drawable.hiragana_se));
        listeKana.add(new Kana (R.drawable.hiragana_so));
        listeKana.add(new Kana (R.drawable.hiragana_ta));
        listeKana.add(new Kana (R.drawable.hiragana_chi));
        listeKana.add(new Kana (R.drawable.hiragana_tsu));
        listeKana.add(new Kana (R.drawable.hiragana_te));
        listeKana.add(new Kana (R.drawable.hiragana_to));
        listeKana.add(new Kana (R.drawable.hiragana_na));
        listeKana.add(new Kana (R.drawable.hiragana_ni));
        listeKana.add(new Kana (R.drawable.hiragana_nu));
        listeKana.add(new Kana (R.drawable.hiragana_ne));
        listeKana.add(new Kana (R.drawable.hiragana_no));
        listeKana.add(new Kana (R.drawable.hiragana_ha));
        listeKana.add(new Kana (R.drawable.hiragana_hi));
        listeKana.add(new Kana (R.drawable.hiragana_fu));
        listeKana.add(new Kana (R.drawable.hiragana_he));
        listeKana.add(new Kana (R.drawable.hiragana_ho));
        listeKana.add(new Kana (R.drawable.hiragana_ma));
        listeKana.add(new Kana (R.drawable.hiragana_mi));
        listeKana.add(new Kana (R.drawable.hiragana_mu));
        listeKana.add(new Kana (R.drawable.hiragana_me));
        listeKana.add(new Kana (R.drawable.hiragana_mo));
        listeKana.add(new Kana (R.drawable.hiragana_ya));
        listeKana.add(new Kana(0));
        listeKana.add(new Kana (R.drawable.hiragana_yu));
        listeKana.add(new Kana(0));
        listeKana.add(new Kana (R.drawable.hiragana_yo));
        listeKana.add(new Kana (R.drawable.hiragana_ra));
        listeKana.add(new Kana (R.drawable.hiragana_ri));
        listeKana.add(new Kana (R.drawable.hiragana_ru));
        listeKana.add(new Kana (R.drawable.hiragana_re));
        listeKana.add(new Kana (R.drawable.hiragana_ro));
        listeKana.add(new Kana (R.drawable.hiragana_wa));
        listeKana.add(new Kana(0));
        listeKana.add(new Kana(0));
        listeKana.add(new Kana(0));
        listeKana.add(new Kana (R.drawable.hiragana_wo));
        listeKana.add(new Kana(0));
        listeKana.add(new Kana(0));
        listeKana.add(new Kana(0));
        listeKana.add(new Kana(0));
        listeKana.add(new Kana (R.drawable.hiragana_n));


        RecyclerView recyclerView = findViewById(R.id.kana_recyclerview);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);


        KanaAdapter kanaAdapter = new KanaAdapter(listeKana);
        recyclerView.setAdapter(kanaAdapter);

        GridLayoutManager manager = new GridLayoutManager (context, 5, GridLayoutManager .VERTICAL, false);
        manager .setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup () {

            @Override
            public int getSpanSize(int arg0) {
                return (arg0 % 10) == 0 ? 1 : 1;
            }
        });
        recyclerView.setLayoutManager(manager);

    }


    //bouton retour du telephone

    @Override
    public void onBackPressed()
    {
        Intent i = new Intent(HiraganaActivity.this, MainActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);
        finish ();
    }
}