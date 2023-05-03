package dev.wony.effectivejava.chapter_2.item_10;

import java.sql.Date;
import java.sql.Timestamp;

/**
 * 아이템 10. equals는 일반 규약을 지켜 재정의하라
 */
public class item_10 {
    public static void main(String[] args) {
        Timestamp timestamp = new Timestamp(1000L);
        Date date = new Date(1000L);

        System.out.println(timestamp.equals(date));
        System.out.println(date.equals(timestamp));

        MyType myType = new MyType();
        MyType myType2 = null;
        System.out.println(timestamp.equals(myType2));
    }
}
