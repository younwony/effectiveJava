package dev.wony.effectivejava.chapter_4.item_16;

public class Point {

    private double x; // 접근자와 변경자 메서드를 활용해 데이터를 캡슐화한다., public 클래스는 절대 가변 필드를 직접 노출해서는 안된다.
    private double y;

    public Point(double x, double y){
        this.x = x;
        this.y = y;
    }

    public double getX(){
        return x;
    }
    public double getY(){
        return y;
    }

    public void setX(double x){
        this.x = x;
    }
    public void setY(double y){
        this.y = y;
    }
}
