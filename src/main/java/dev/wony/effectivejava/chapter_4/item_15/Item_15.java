package dev.wony.effectivejava.chapter_4.item_15;

import java.util.List;

/**
 * 아이템 15. 클래스와 멤버의 접근 권한을 최소화하라
 */
public class Item_15 {

    public static final Thing[] VALUES = {new Thing(), new Thing()};

    private static final Thing[] PRIVATE_VALUES = {new Thing(), new Thing()};

    public static final List<Thing> VALUES_LIST = List.of(PRIVATE_VALUES);
    public static final Thing[] values(){
        return PRIVATE_VALUES.clone();
    }
    public static void main(String[] args) {

    }
}
