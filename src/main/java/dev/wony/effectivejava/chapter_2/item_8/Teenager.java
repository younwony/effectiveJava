package dev.wony.effectivejava.chapter_2.item_8;

public class Teenager {
    public static void main(String[] args) {
        // try-with-resources를 사용하지 않아 방청소를 출력되리라 기대할 수 없다.
        // Room 생성자에서 Cleaner의 register 메서드를 호출하면서 Room을 참조하므로 Room은 Cleaner가 수거할 때까지 회수되지 않는다.
        // 따라서 Room의 close 메서드는 호출되지 않고, Room에 담긴 쓰레기 수도 0으로 초기화되지 않는다.
        // 이 프로그램은 "Peace out"을 출력하고 종료된다.
        // 이런 상황을 방지하려면 Room을 try-with-resources 블록 바깥에서 초기화해야 한다.
        // try-with-resources 블록 바깥에서 초기화하면 Room이 영원히 열려있지 않게 된다.
        Room room = new Room(99);
        System.out.println("Peace out");
    }
}
