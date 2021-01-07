package fr.taigaprozz.kanjikana;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import fr.taigaprozz.R;
import fr.taigaprozz.kanjikana.Kana.KatakanaActivity;
import fr.taigaprozz.kanjikana.ui.main.SectionsPagerAdapter;

public class TabbedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_tabbed);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter (this, getSupportFragmentManager ());
        ViewPager viewPager = findViewById (R.id.view_pager);
        viewPager.setAdapter (sectionsPagerAdapter);
        TabLayout tabs = findViewById (R.id.tabs);
        tabs.setupWithViewPager (viewPager);
        FloatingActionButton fab = findViewById (R.id.fab);

        fab.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                Snackbar.make (view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction ("Action", null).show ();
            }
        });
    }

    //bouton retour du telephone
    @Override
    public void onBackPressed()
    {
        Intent i = new Intent(TabbedActivity.this, MainActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);
        finish ();
    }
}