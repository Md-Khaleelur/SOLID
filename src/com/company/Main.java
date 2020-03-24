package com.company;

// Shape class is open for extension but closed for modification (OCP)
// Substitute what can be fully extended (Liskov's Substitution principle) - Shape class fully extended by Rectangle/Square class
// DIP - classes should depend on abstractions and not concretions

abstract class Shape {
    public abstract double area();
}

//Interface Segregation principle (Each interface with only one responsibility)
interface PDFPrintable{
    void printPDF();
}

interface WordPrintable{
    void printWord();
}

//Instead of single Shape class to calculate areas of all shapes, the respective classes- Rectangle and Square can do it (SRP)
class Rectangle extends Shape implements PDFPrintable{

    int height;
    int width;

    Rectangle(int height,int width){
        this.height=height;
        this.width=width;
    }

    @Override
    public double area() {
        return height*width;
    }

    @Override
    public void printPDF() {
        System.out.println("The rectangle area is printed in PDF document");
    }

}

class Square extends Shape implements PDFPrintable{

    int side;

    Square(int side){
        this.side=side;
    }

    @Override
    public double area() {
        return side*side;
    }

    @Override
    public void printPDF() {
        System.out.println("The square area is printed in PDF document");
    }

}


public class Main {

    public static void main(String[] args) {

        Square square = new Square(4);
        System.out.println("Area: "+square.area());
        square.printPDF();

        Rectangle rectangle = new Rectangle(4,5);
        System.out.println("Area: "+rectangle.area());
        rectangle.printPDF();

    }

}
