package dev.wony.effectivejava.chapter_2.item_14;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.TreeSet;

/**
 * 아이템 14 : Comparable을 구현할지 고려하라
 */
public class Item_14 {

    public static void main(String[] args) {

        HashSet<BigDecimal> hashSet = new HashSet<>();
        TreeSet<BigDecimal> treeSet = new TreeSet<>();

        BigDecimal bigDecimal1 = new BigDecimal("1.0");
        BigDecimal bigDecimal2 = new BigDecimal("1.00");

        boolean compareTo = bigDecimal1.compareTo(bigDecimal2) == 0;

        boolean equals = bigDecimal1.equals(bigDecimal2);

        hashSet.add(bigDecimal1);
        hashSet.add(bigDecimal2);

        treeSet.add(bigDecimal1);
        treeSet.add(bigDecimal2);

        System.out.println(compareTo); // true
        System.out.println(equals); // false
        System.out.println(hashSet.size()); // 2
        System.out.println(treeSet.size()); // 1
    }
}
