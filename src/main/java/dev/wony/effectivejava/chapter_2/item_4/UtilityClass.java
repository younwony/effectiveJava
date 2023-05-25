package dev.wony.effectivejava.chapter_2.item_4;

public class UtilityClass {

    /* 인스턴스화 방지 */
    private UtilityClass(){
        throw new AssertionError();
    }
}
