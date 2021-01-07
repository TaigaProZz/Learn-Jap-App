package fr.taigaprozz.kanjikana.Kana;

import android.annotation.SuppressLint;
import android.content.Context;
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
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private KanaAdapter kanaAdapter;
    public Context context;

    @SuppressLint({"ResourceType", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_katakana);

        // bouton retour en haut a gauche
        TextView retour_arriere = findViewById (R.id.retour_arriere);
        retour_arriere.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent otherActivity3 = new Intent (getApplicationContext (), MainActivity.class);
                startActivity (otherActivity3);
                finish ();

            }
        }   );


        // bouton page katakana
        Button button = findViewById (R.id.button_hiragana);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent otherActivity = new Intent(getApplicationContext (), HiraganaActivity.class);
                startActivity (otherActivity);
                finish ();
            }
        }    );

        // liste
        List<Kana> listeKana = new ArrayList<>();
        listeKana.add(new Kana (R.drawable.hiragana_a));
        listeKana.add(new Kana (R.drawable.hiragana_i));
        listeKana.add(new Kana (R.drawable.kana_u_icon));
        listeKana.add(new Kana (R.drawable.kana_e_icon));
        listeKana.add(new Kana (R.drawable.kana_o_icon));
        listeKana.add(new Kana (R.drawable.kana_ka_icon));
        listeKana.add(new Kana (R.drawable.kana_ki_icon));
        listeKana.add(new Kana (R.drawable.kana_ku_icon));
        listeKana.add(new Kana (R.drawable.kana_ke_icon));
        listeKana.add(new Kana (R.drawable.kana_ko_icon));
        listeKana.add(new Kana (R.drawable.kana_sa_icon));
        listeKana.add(new Kana (R.drawable.kana_shi_icon));
        listeKana.add(new Kana (R.drawable.kana_su_icon));
        listeKana.add(new Kana (R.drawable.kana_se_icon));
        listeKana.add(new Kana (R.drawable.kana_so_icon));
        listeKana.add(new Kana (R.drawable.kana_ta_icon));
        listeKana.add(new Kana (R.drawable.kana_chi_icon));
        listeKana.add(new Kana (R.drawable.kana_tsu_icon));
        listeKana.add(new Kana (R.drawable.kana_te_icon));
        listeKana.add(new Kana (R.drawable.kana_to_icon));
        listeKana.add(new Kana (R.drawable.kana_na_icon));
        listeKana.add(new Kana (R.drawable.kana_ni_icon));
        listeKana.add(new Kana (R.drawable.kana_nu_icon));
        listeKana.add(new Kana (R.drawable.kana_ne_icon));
        listeKana.add(new Kana (R.drawable.kana_no_icon));


        recyclerView = findViewById(R.id.kana_recyclerview);

        layoutManager = new LinearLayoutManager (this);
        recyclerView.setLayoutManager(layoutManager);


        kanaAdapter = new KanaAdapter (listeKana);
        recyclerView.setAdapter(kanaAdapter);

        GridLayoutManager manager = new GridLayoutManager (context, 5, GridLayoutManager .VERTICAL, false);
        manager .setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup () {

            @Override
            public int getSpanSize(int arg0) {
                return (arg0 % 4) == 0 ? 1 : 1;
            }
        });
        recyclerView.setLayoutManager(manager);
    }

    //bouton retour du telephone
    @Override
    public void onBackPressed()
    {
        Intent i = new Intent(KatakanaActivity.this, MainActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);
        finish ();
    }
}