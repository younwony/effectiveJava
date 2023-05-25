package dev.wony.effectivejava.chapter_3.item_13;

/**
 * 아이템 13. clone 재정의는 주의해서 진행하라
 */
public class Item_13 {
    public static void main(String[] args) throws CloneNotSupportedException {

        B b1 = new B();
        B b2 = new A();
        Object cloneB1 = b1.clone();
        Object cloneB2 = b2.clone();
        System.out.println(cloneB1.getClass()); // B
        System.out.println(cloneB2.getClass()); // A
        System.out.println(cloneB1.getClass() == cloneB2.getClass()); // false

    }

    static class B implements Cloneable {
        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }

    static class A extends B implements Cloneable{
        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }

    static class C {

        // 복사 생성자
        public C(C c) {
            // ...
        }

        // 복사 팩토리
        public static C newInstance(C c) {
            // ...
            return new C(c);
        }
    }
}
