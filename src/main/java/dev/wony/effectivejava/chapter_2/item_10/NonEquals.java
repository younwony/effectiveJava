package dev.wony.effectivejava.chapter_2.item_10;

public class NonEquals {
    @Override
    public boolean equals(Object obj) {
        throw new AssertionError(); // 호출 금지!
    }
}
