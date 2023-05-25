package dev.wony.effectivejava.chapter_3.item_14;

public final class CaseInsensitiveString implements Comparable<CaseInsensitiveString>{

    private final String s;

    public CaseInsensitiveString(String s){
        if(s == null)
            throw new NullPointerException();
        this.s = s;
    }

    @Override
    public int compareTo(CaseInsensitiveString cis) {
        return String.CASE_INSENSITIVE_ORDER.compare(s, cis.s);
    }
}
