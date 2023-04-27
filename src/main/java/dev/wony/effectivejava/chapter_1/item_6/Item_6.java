package dev.wony.effectivejava.chapter_1.item_6;

/**
 * 아이템 6. 불필요한 객체 생성을 피하라
 */
public class Item_6 {
    public static void main(String[] args) {
    }

    /* String.matches */
    static boolean isRomanNumeral(String s){
        return s.matches("^(?=.)M*(C[MD]|D?C{0,3})" + "(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");
    }

    static long sum(){
        Long sum = 0L; // long sum = 0L; 으로 하면 2.5배 빠르다. AutoBoxing 때문에
        for (long i = 0; i < Integer.MAX_VALUE; i++) {
            sum += i;
        }
        return sum;
    }
}
