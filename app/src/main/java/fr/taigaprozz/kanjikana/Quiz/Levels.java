package fr.taigaprozz.kanjikana.Quiz;

public class Levels {
    private static final Levels levels = new Levels();
    private int level_hiragana;
    private int level_katakana;

    public static Levels getInstance() {
        return levels;
    }

    public int getLevel_hiragana() {
        return level_hiragana;
    }

    public int setLevel_hiragana(int level_hiragana) {
        this.level_hiragana = level_hiragana;
        return level_hiragana;
    }


    public int getLevel_katakana() {
        return level_katakana;
    }

    public void setLevel_katakana(int level_katakana) {
        this.level_katakana = level_katakana;
    }
}
