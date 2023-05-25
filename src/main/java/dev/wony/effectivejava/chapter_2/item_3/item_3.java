package dev.wony.effectivejava.chapter_2.item_3;

/**
 * 아이템 3. private 생성자나 열거 타입으로 싱글턴임을 보증하라
 */
public class item_3 {
    public static void main(String[] args) {
        // public static final 필드 방식의 싱글턴
        Elvis elvis = Elvis.INSTANCE;
        elvis.leaveTheBuilding();

        // 정적 팩터리 방식의 싱글턴
        Elvis elvis2 = Elvis.getInstance();
        elvis2.leaveTheBuilding2();

        // 열거 타입 방식의 싱글턴
        Elvis.Elvis3 elvis3 = Elvis.Elvis3.INSTANCE;
        elvis3.leaveTheBuilding();
    }
}
