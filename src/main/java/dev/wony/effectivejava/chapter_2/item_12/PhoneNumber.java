package dev.wony.effectivejava.chapter_2.item_12;

import java.util.Objects;

public class PhoneNumber {
    private final int areaCode;
    private final int prefix;
    private final int lineNum;

    public PhoneNumber(int areaCode, int prefix, int lineNum) {
        this.areaCode = areaCode;
        this.prefix = prefix;
        this.lineNum = lineNum;
    }

    /**
     * 폰 번호를 문자열로 반환
     * PhoneNumber{areaCode=82, prefix=10, lineNum=1234}
     */
    @Override
    public String toString() {
        return "PhoneNumber{" +
                "areaCode=" + areaCode +
                ", prefix=" + prefix +
                ", lineNum=" + lineNum +
                '}';
    }
}
