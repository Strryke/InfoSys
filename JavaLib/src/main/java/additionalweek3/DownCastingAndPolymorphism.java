package additionalweek3;

import java.util.ArrayList;

public class DownCastingAndPolymorphism {
    public static void main(String[] args) {
        Circle c = new Circle();
        Rectangle r = new Rectangle();
        RegularTriangle t = new RegularTriangle();

        ArrayList<GeometricObject> arr = new ArrayList<>();
        arr.add(c);
        arr.add(r);
        arr.add(t);

        // Dynamic Binding
        for (GeometricObject g: arr) {
            // toString() method is invoked from Circle, Rectangle, and then Geometric Object class
            // because Triangle class doesnt override toString() method
            // toString() is dynamically bound to different classes. And thus is called Dynamic Binding
            System.out.println(g.toString());
        }

        System.out.println("\n");

        // Down Casting
        for (GeometricObject g: arr) {
            printInfo(g);
        }

    }

    static void printInfo(GeometricObject o) {
        // Downcast example below here:
        // printInfo method can take any GeometricObject, but then you need to downcast
        // because you need to access the subclass method from superclass object.
        if (o instanceof Circle)
            System.out.println("A circle with radius " + ((Circle) o).getRadius());
        else if (o instanceof Rectangle)
            System.out.println("A rectangle with width = " + ((Rectangle) o).getWidth()
                    + " and height = " + ((Rectangle) o).getHeight());
        else if (o instanceof RegularTriangle)
            System.out.println("A triangle with side = " + ((RegularTriangle) o).getSide());
    }
}

class GeometricObject {
    String color = "White";

    String getColor() {
        return color;
    }

    @Override
    public String toString() {  // Override java.lang.Object toString() method
        return "This is Geometric Object";
    }
}

class Circle extends GeometricObject {
    private double radius = 0.0; // encapsulation

    public double getRadius() {
        return radius;
    }

    @Override
    public String toString() { // Override Geometric Object toString() method
        return "This is Circle";
    }
}

class Rectangle extends GeometricObject {
    private double width = 0.0;  // encapsulation
    private double height = 0.0;

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public String toString() { // Override Geometric Object toString() method
        return "This is Rectangle";
    }
}

class RegularTriangle extends GeometricObject {
    private double side = 1.0; // encapsulation

    public double getSide() {
        return side;
    }
}
