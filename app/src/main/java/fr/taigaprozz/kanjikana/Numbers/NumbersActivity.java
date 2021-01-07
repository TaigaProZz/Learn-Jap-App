package fr.taigaprozz.kanjikana.Numbers;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import fr.taigaprozz.R;
import fr.taigaprozz.kanjikana.MainActivity;


public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_numbers);
    }


    // bouton retour avec bouton du phone
    @Override
    public void onBackPressed()
    {
        Intent i = new Intent(NumbersActivity.this, MainActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);
        finish ();
    }

}