package dev.wony.effectivejava.chapter_1.item_5;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class SpellChecker {
    private final Lexicon dictionary;

    public SpellChecker(Lexicon dictionary) {
        this.dictionary = Objects.requireNonNull(dictionary);
    }

    public boolean isValid(String word){
        return true;
    }

    public static List<String> suggestions(String typo){
        return new ArrayList<>();
    }
}