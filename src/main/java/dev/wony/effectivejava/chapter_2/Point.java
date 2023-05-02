package dev.wony.effectivejava.chapter_2;

import java.util.Objects;
import java.util.Set;

public class Point {

    final int x;
    final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    static final Set<Point> unitCircle = Set.of(
            new Point(1,0), new Point(0,1),
            new Point(-1,0), new Point(0,-1)
    );

    public static boolean onUnitCircle(Point p){
        return unitCircle.contains(p);
    }
}
