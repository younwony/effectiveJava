package dev.wony.effectivejava.chapter_4.item_19;

import java.time.Instant;

public class Sub extends Super {

    // 초기화되지 않은 final 필드. 생성자에서 초기화한다.
    private final Instant instant;

    public Sub() {
        instant = Instant.now();
    }

    // 재정의 가능 메서드. 상위 클래스의 생성자가 호출한다.
    public void overrideMe() {
        System.out.println("instant = " + instant);
    }

    public static void main(String[] args) {
        Sub sub = new Sub();
        // 상위 클래스 생성이 먼저 진행 되기 때문에 instant는 null이다.
        sub.overrideMe();
    }
}
