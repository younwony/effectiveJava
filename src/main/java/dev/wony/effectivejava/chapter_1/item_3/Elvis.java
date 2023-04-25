package dev.wony.effectivejava.chapter_1.item_3;

public class Elvis {

    // public static final 필드 방식의 싱글턴
    public static final Elvis INSTANCE = new Elvis();

    private Elvis() {
    }

    public void leaveTheBuilding() {
        System.out.println("Elvis has left the building.");
    }

    // 정적 팩터리 방식의 싱글턴
    private static final Elvis INSTANCE2 = new Elvis();

    public static Elvis getInstance() {
        return INSTANCE2;
    }

    public void leaveTheBuilding2() {
        System.out.println("Elvis has left the building.");
    }

    // 싱글턴임을 보장해주는 readResolve 메서드
    private Object readResolve() {
        // '진짜' Elvis를 반환하고, 가짜 Elvis는 가비지 컬렉터에 맡긴다.
        return INSTANCE;
    }

    // 열거 타입 방식의 싱글턴 - 바람직한 방법
    public enum Elvis3 {
        INSTANCE;

        public void leaveTheBuilding() {
            System.out.println("Elvis has left the building.");
        }
    }
}
