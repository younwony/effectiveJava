package dev.wony.effectivejava.chapter_2.item_8;

import java.lang.ref.Cleaner;

public class Room implements AutoCloseable {

        private static final Cleaner cleaner = Cleaner.create();

        // 청소가 필요한 자원. 절대 Room을 참조해서는 안 된다!
        private static class State implements Runnable{

            int numJunkPiles; // Room 안의 쓰레기 수

            State(int numJunkPiles){
                this.numJunkPiles = numJunkPiles;
            }

            // close 메서드나 cleaner가 호출한다.
            @Override
            public void run() {
                System.out.println("Cleaning Room");
                numJunkPiles = 0;
            }
        }

        private final State state;

        private final Cleaner.Cleanable cleanable;

        public Room(int numJunkPiles){
            state = new State(numJunkPiles);
            cleanable = cleaner.register(this, state);
        }

        @Override
        public void close() throws Exception {
            cleanable.clean();
        }
}
