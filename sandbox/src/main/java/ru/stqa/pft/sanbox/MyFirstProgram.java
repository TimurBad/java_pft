package ru.stqa.pft.sanbox;

public class MyFirstProgram {

    public static void main(String[] args) {
        Square s = new Square(5);
        Rectangle r = new Rectangle(4,6);
        System.out.println("Hello, world!");

        System.out.println("test " + s.l + " = " + s.area());
        System.out.println("test Rectangle =" + r.area());

    }




}