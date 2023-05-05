package dev.wony.effectivejava.chapter_2.item_13;

public class PhoneNumber implements Cloneable {

    private final short areaCode, prefix, lineNum;

    public PhoneNumber(short areaCode, short prefix, short lineNum) {
        this.areaCode = areaCode;
        this.prefix = prefix;
        this.lineNum = lineNum;
    }

    @Override
    public PhoneNumber clone() {
        try {
            return (PhoneNumber) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(); // 모든 필드가 기본 타입이기 때문에 일어날 수 없는 일이다. or 불변객체의경우
        }
    }
}
