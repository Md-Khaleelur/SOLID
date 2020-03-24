
//ISP Violation
interface Printable{

    void printPDF();
    void printWord();

}

//SRP Violation
class Shape{

    int side;
    int width;
    int height;

    public double squareArea() {
        return side*side;
    }

    public double rectangleArea() {
        return height*width;
    }

}

//DIP violation
class AreaCalculator{

    int side;
    int width;
    int height;

    public double squareArea() {
        return side*side;
    }

    public double rectangleArea() {
        return height*width;
    }

}


class Rectangle{

    int height;
    int width;

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

}

//Unnecessary extending the class -LSP Violation
class Square extends Rectangle{

    private int side;

    public int getSide() {
        return side;
    }

    public void setSide(int side) {
        this.side = super.height;
    }

}



