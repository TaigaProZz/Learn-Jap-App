package fr.taigaprozz.kanjikana.ui.main;


import android.content.Intent;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import fr.taigaprozz.kanjikana.Kana.KatakanaActivity;
import fr.taigaprozz.kanjikana.MainActivity;

public class PageViewModel extends ViewModel {

    private MutableLiveData<Integer> mIndex = new MutableLiveData<> ();
    private LiveData<String> mText = Transformations.map (mIndex, new Function<Integer, String> () {
        @Override
        public String apply(Integer input) {
            return "Hello world from section: " + input;
        }
    });

    public void setIndex(int index) {
        mIndex.setValue (index);
    }

    public LiveData<String> getText() {
        return mText;
    }
    //bouton retour du telephone

}
