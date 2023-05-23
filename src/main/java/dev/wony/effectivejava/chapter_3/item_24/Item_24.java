package dev.wony.effectivejava.chapter_3.item_24;

/**
 * 아이템 24. 멤버 클래스는 되도록 static으로 만들라
 */
public class Item_24 {
    public static void main(String[] args) {
        OuterClass outerObj = new OuterClass();
        OuterClass.InnerClass innerObj = outerObj.new InnerClass();

        innerObj.innerMethod();

        Anonymous anonymous = new Anonymous() {
            @Override
            public void anonymousMethod() {
                System.out.println("Anonymous Method");
            }
        };

        class LocalClass {
            public void localMethod() {
                System.out.println("Local Method");
            }
        }
    }
}
