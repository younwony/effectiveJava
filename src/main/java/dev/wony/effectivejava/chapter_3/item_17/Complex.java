package dev.wony.effectivejava.chapter_3.item_17;

public final class Complex {

    private final double re;
    private final double im;

    private Complex(double re, double im){
        this.re = re;
        this.im = im;
    }
    public static Complex valueOf(double re, double im){
        return new Complex(re, im);
    }

    public double realPart(){
        return re;
    }

    public double imaginaryPart(){
        return im;
    }

    public Complex plus(Complex c){
        return new Complex(re + c.re, im + c.im);
    }

    public Complex minus(Complex c){
        return new Complex(re - c.re, im - c.im);
    }

    public Complex times(Complex c){
        return new Complex(re * c.re - im * c.im, re * c.im + im * c.re);
    }

    public Complex dividedBy(Complex c){
        double tmp = c.re * c.re + c.im * c.im;
        return new Complex((re * c.re + im * c.im) / tmp, (im * c.re - re * c.im) / tmp);
    }

    @Override
    public boolean equals(Object o){
        if(o == this)
            return true;
        if(!(o instanceof Complex))
            return false;
        Complex c = (Complex) o;

        return Double.compare(re, c.re) == 0 && Double.compare(im, c.im) == 0;
    }

    @Override
    public int hashCode(){
        int result = 17 + hashDouble(re);
        result = 31 * result + hashDouble(im);
        return result;
    }

    private int hashDouble(double val){
        long longBits = Double.doubleToLongBits(re);
        return (int) (longBits ^ (longBits >>> 32));
    }
}
