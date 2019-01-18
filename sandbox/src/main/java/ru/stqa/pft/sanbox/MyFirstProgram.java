package ru.stqa.pft.sanbox;

public class MyFirstProgram {

    public static void main(String[] args) {
        Square s = new Square(2);
        Rectangle r = new Rectangle();
        r.a = 4;
        r.b = 6;
        System.out.println("Hello, world!");

        System.out.println("test " + s.l);
        System.out.println("test " + area(s));
        System.out.println("test " + area(r));

    }

    public static double area(Square s) {
        return s.l * s.l;
    }

    public static double area(Rectangle r) {
        return r.a * r.b;
    }


}