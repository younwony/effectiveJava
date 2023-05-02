package dev.wony.effectivejava.chapter_2;

public class CounterPoint {

    private final Point point;
    private final int x;
    private final int y;
    public CounterPoint(int x, int y) {
        this.x = x;
        this.y = y;
        point = new Point(x, y);
    }

    /**
     * Point 뷰 반환
     */
    public Point asPoint(){
        return point;
    }
    
    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof CounterPoint))
            return false;
        CounterPoint cp = (CounterPoint) obj;
        return cp.point.equals(point);
    }
}
