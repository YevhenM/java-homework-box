import java.util.ArrayList;


public class Box {
    public static void main(String[] args) {

        Box someBox = new Box(10);
        Rectangle rectangle1 = new Rectangle(1,2);
        Square square1 = new Square(3);
        Circle circle1 = new Circle(1.5f);

        System.out.println("Free area = " + someBox.freeArea());
        System.out.println(someBox.addShape(rectangle1));
        System.out.println("Free area = " + someBox.freeArea());
        System.out.println(someBox.addShape(square1));
        System.out.println("Free area = " + someBox.freeArea());
        System.out.println(someBox.addShape(circle1));
        System.out.println("Free area = " + someBox.freeArea());
    }

    float area;
    ArrayList<Shape> shapes = new ArrayList();

    public Box(float area) {
        this.area = area;
    }

    public boolean addShape(Shape shape) {
        if (shape.getArea() < area) {
            shapes.add(shape);
            area -= shape.getArea();
            return true;
        }
        return false;
    }

    public float freeArea(){
        return area;
    }
}

abstract class Shape {
    float area;
    public abstract float getArea();
}

class Rectangle extends Shape {
    private float width;
    private float height;

    Rectangle (float width, float height){
        this.width = width;
        this.height = height;
    }

    public float getArea() {
        return width * height;
    }
}

class Square extends Shape {
    private float side;

    Square (float side){
        this.side = side;
    }

    public float getArea() {
        return side * side;
    }
}

class Circle extends Shape {
    private float radius;

    Circle (float radius){
        this.radius = radius;
    }

    public float getArea() {
        return (float) (Math.PI * radius * radius);
    }
}
