package dev.wony.effectivejava.chapter_1;

import java.util.ArrayList;
import java.util.Enumeration;

public class StackWalker {

    private String option;

    private StackWalker(String option) {
        this.option = option;
    }

    public static StackWalker getInstance(String option) {
        return new StackWalker(option);
    }

}
