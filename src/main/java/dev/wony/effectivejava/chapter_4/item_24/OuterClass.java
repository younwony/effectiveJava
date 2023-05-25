package dev.wony.effectivejava.chapter_4.item_24;

public class OuterClass {
    private static int outerData = 0;

    public static class StaticNestedClass {

        public void display() {
            System.out.println("Outer data: " + outerData);
        }

        public static void staticMethod() {
            System.out.println("Static method in StaticNestedClass");
        }
    }

    public void outerMethod() {
        System.out.println("Outer method called");
    }

    public class InnerClass {

        public void innerMethod() {
            System.out.println("Inner method called");

            // 바깥 인스턴스의 메서드 호출
            outerMethod();

            // 바깥 인스턴스의 참조 가져오기
            OuterClass.this.outerData = 20;
            System.out.println("Updated outer data: " + OuterClass.this.outerData);
        }
    }
}
