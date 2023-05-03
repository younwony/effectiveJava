package dev.wony.effectivejava.chapter_2.item_11;

import java.util.HashMap;
import java.util.Map;

/**
 * 아이템 11. equals를 재정의하려거든 hashCode도 재정의하라
 */
public class Item_11 {
    public static void main(String[] args) {
        Map<PhoneNumber, String> m = new HashMap<>();
        m.put(new PhoneNumber(707, 867, 5309), "제니");

        System.out.println(m.get(new PhoneNumber(707, 867, 5309)));
    }
}
