package dev.wony.effectivejava.chapter_2.item_10;

public class MyType {
    @Override
    public boolean equals(Object obj) {
        // 묵시적 Null 검사
         if(!(obj instanceof MyType))
             return false;
         MyType myType = (MyType) obj;
        return super.equals(myType);
    }
}
