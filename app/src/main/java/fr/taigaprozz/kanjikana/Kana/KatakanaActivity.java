package fr.taigaprozz.kanjikana.Kana;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import fr.taigaprozz.R;
import fr.taigaprozz.kanjikana.MainActivity;


public class KatakanaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_katakana);

        // collect components from view
        setSupportActionBar(findViewById(R.id.toolbar_katakana));
        Button button = findViewById(R.id.button_hiragana);
        TextView goingBackArrow = findViewById(R.id.goingBackArrow);

        // return button arrow at the top left
        goingBackArrow.setOnClickListener(v -> {
            finish();
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
        });


        // click button switch to hiragana
        button.setOnClickListener(v -> {
            finish();
            startActivity(new Intent(getApplicationContext(), HiraganaActivity.class));

        });

        // list image katakana
        List<Kana> listeKana = new ArrayList<>();
        listeKana.add(new Kana(R.drawable.katakana_a));     listeKana.add(new Kana(R.drawable.katakana_i));     listeKana.add(new Kana(R.drawable.katakana_u));
        listeKana.add(new Kana(R.drawable.katakana_e));     listeKana.add(new Kana(R.drawable.katakana_o));     listeKana.add(new Kana(R.drawable.katakana_ka));
        listeKana.add(new Kana(R.drawable.katakana_ki));    listeKana.add(new Kana(R.drawable.katakana_ku));    listeKana.add(new Kana(R.drawable.katakana_ke));
        listeKana.add(new Kana(R.drawable.katakana_ko));    listeKana.add(new Kana(R.drawable.katakana_sa));    listeKana.add(new Kana(R.drawable.katakana_shi));
        listeKana.add(new Kana(R.drawable.katakana_su));    listeKana.add(new Kana(R.drawable.katakana_se));    listeKana.add(new Kana(R.drawable.katakana_so));
        listeKana.add(new Kana(R.drawable.katakana_ta));    listeKana.add(new Kana(R.drawable.katakana_chi));   listeKana.add(new Kana(R.drawable.katakana_tsu));
        listeKana.add(new Kana(R.drawable.katakana_te));    listeKana.add(new Kana(R.drawable.katakana_to));    listeKana.add(new Kana(R.drawable.katakana_na));
        listeKana.add(new Kana(R.drawable.katakana_ni));    listeKana.add(new Kana(R.drawable.katakana_nu));    listeKana.add(new Kana(R.drawable.katakana_ne));
        listeKana.add(new Kana(R.drawable.katakana_no));    listeKana.add(new Kana(R.drawable.katakana_ha));    listeKana.add(new Kana(R.drawable.katakana_hi));
        listeKana.add(new Kana(R.drawable.katakana_fu));    listeKana.add(new Kana(R.drawable.katakana_he));    listeKana.add(new Kana(R.drawable.katakana_ho));
        listeKana.add(new Kana(R.drawable.katakana_ma));    listeKana.add(new Kana(R.drawable.katakana_mi));    listeKana.add(new Kana(R.drawable.katakana_mu));
        listeKana.add(new Kana(R.drawable.katakana_me));    listeKana.add(new Kana(R.drawable.katakana_mo));    listeKana.add(new Kana(R.drawable.katakana_ya));
        listeKana.add(new Kana(0));                         listeKana.add(new Kana(R.drawable.katakana_yu));    listeKana.add(new Kana(0));
        listeKana.add(new Kana(R.drawable.katakana_yo));    listeKana.add(new Kana(R.drawable.katakana_ra));    listeKana.add(new Kana(R.drawable.katakana_ri));
        listeKana.add(new Kana(R.drawable.katakana_ru));    listeKana.add(new Kana(R.drawable.katakana_re));    listeKana.add(new Kana(R.drawable.katakana_ro));
        listeKana.add(new Kana(R.drawable.katakana_wa));    listeKana.add(new Kana(0));                         listeKana.add(new Kana(0));
        listeKana.add(new Kana(0));                         listeKana.add(new Kana(R.drawable.katakana_wo));    listeKana.add(new Kana(0));
        listeKana.add(new Kana(0));                         listeKana.add(new Kana(0));                         listeKana.add(new Kana(0));
        listeKana.add(new Kana(R.drawable.katakana_n));

        // recycler view params
        RecyclerView recyclerView = findViewById(R.id.katakana_recyclerview);
        RecyclerView.LayoutManager layoutManager;
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        GridLayoutManager manager = new GridLayoutManager(getApplicationContext(), 5, GridLayoutManager.VERTICAL, false);
        manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int arg0) {
                return (arg0 % 4) == 0 ? 1 : 1;
            }
        });
        recyclerView.setLayoutManager(manager);

        // set adapter to recycler view
        KanaAdapter kanaAdapter;
        kanaAdapter = new KanaAdapter(listeKana);
        recyclerView.setAdapter(kanaAdapter);



    }

    // return button of the phone
    @Override
    public void onBackPressed() {
        finish();
        startActivity(new Intent(getApplicationContext(), MainActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
    }
}