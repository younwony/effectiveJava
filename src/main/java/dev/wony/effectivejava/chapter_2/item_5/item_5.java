package dev.wony.effectivejava.chapter_2.item_5;

/**
 * 아이템 5. 자원을 직접 명시하지 말고 의존 객체 주입을 사용하라
 */
public class item_5 {
    public static void main(String[] args) {
        // Lexicon 인터페이스를 구현한 KoreanDictionary를 사용하는 SpellChecker
        // 의존성 주입
        // SpellChecker는 Lexicon 인터페이스에만 의존하며, 어떤 구체적인 클래스가 Lexicon 인터페이스를 구현했는지는 전혀 모른다.
        SpellChecker spellChecker = new SpellChecker(new KoreanDictionary());
    }
}
