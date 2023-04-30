package dev.wony.effectivejava.chapter_1.item_8;

public class Adult {

        public static void main(String[] args) throws Exception {
            // try-with-resources를 사용해 예외를 회피한다.
            try(Room room = new Room(7)){
                System.out.println("안녕");
            }
        }
}
