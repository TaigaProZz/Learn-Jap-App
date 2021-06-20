package fr.taigaprozz.kanjikana.quiz;

public class Levels {
    private static final Levels levels = new Levels();
    private int levelHiragana;
    private int levelKatakana;

    public static Levels getInstance() {
        return levels;
    }

    public int getLevelHiragana() {
        return levelHiragana;
    }

    public int setLevelHiragana(int levelHiragana) {
        this.levelHiragana = levelHiragana;
        return levelHiragana;
    }


    public int getLevelKatakana() {
        return levelKatakana;
    }

    public void setLevelKatakana(int levelKatakana) {
        this.levelKatakana = levelKatakana;
    }
}
