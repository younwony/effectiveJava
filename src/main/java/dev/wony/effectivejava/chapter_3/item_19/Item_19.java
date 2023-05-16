package dev.wony.effectivejava.chapter_3.item_19;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 아이템 19. 상속을 고려해 설계하고 문서화하라
 */
public class Item_19 {

    private static final List<String> PRIVATE_VALUES = Collections.unmodifiableList(new ArrayList<>());
    public static void main(String[] args) {
        PRIVATE_VALUES.add("1");

        for (String privateValue : PRIVATE_VALUES) {
            System.out.println("privateValue = " + privateValue);
        }
    }
}
