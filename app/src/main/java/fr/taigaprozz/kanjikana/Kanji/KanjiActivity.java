package fr.taigaprozz.kanjikana.Kanji;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import fr.taigaprozz.R;
import fr.taigaprozz.kanjikana.MainActivity;


public class KanjiActivity extends AppCompatActivity {

    private ImageView retour_arriere;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kanji);



        this.retour_arriere = findViewById (R.id.retour_arriere);

        retour_arriere.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent otherActivity3 = new Intent (getApplicationContext (), MainActivity.class);
                startActivity (otherActivity3);
                finish ();

            }
        }          );


    }
    // bouton retour avec bouton du phone
    @Override
    public void onBackPressed()
    {
        Intent i = new Intent(KanjiActivity.this, MainActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);
        finish ();
    }

}