package dev.wony.effectivejava.chapter_2.item_1;

public class StackWalker {

    private String option;

    private StackWalker(String option) {
        this.option = option;
    }

    public static StackWalker getInstance(String option) {
        return new StackWalker(option);
    }

}
