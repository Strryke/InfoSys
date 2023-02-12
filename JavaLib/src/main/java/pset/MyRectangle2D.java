package pset;


public class MyRectangle2D {
    public static void main(String[] args) {
        MyRectangle2D r = new MyRectangle2D(2,2,1,1);
//        System.out.println(r.contains(3,2));
//        System.out.println(Arrays.deepToString(r.corners()));
        MyRectangle2D smol = new MyRectangle2D(2,3,0.1,1);
        System.out.println(r.contains(smol));
    }
    double x, y, width, height;

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public MyRectangle2D() {
        this(0, 0, 1, 1);
    }

    public MyRectangle2D(double x, double y, double width, double height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public double getArea() {
        return (this.width * this.height);
    }

    public double getPerimeter() {
        return ((2 * this.width) + (2 * this.height));
    }

    public boolean contains(double x, double y) {
        boolean output = false;
        double[] x_range = {getX() - getWidth() / 2, getX() + getWidth() / 2};
        double[] y_range = {getY() - getHeight() / 2, getY() + getHeight() / 2};

        if (x > x_range[0] && x < x_range[1] && y > y_range[0] && y < y_range[1]) output = true;
        return output;
    }

    public double[][] corners() {
        // returns the 4 corners of the rectangle -> top left first, clockwise.
        double x, y, width, height;
        x = getX();
        y = getY();
        width = getWidth();
        height = getHeight();

        double offset_x = width / 2;
        double offset_y = height / 2;

        double[][] output = {
                {x - offset_x, y + offset_y},
                {x + offset_x, y + offset_y},
                {x + offset_x, y - offset_y},
                {x - offset_x, y - offset_y}
        };

        return output;
    }

    public boolean contains(MyRectangle2D r) {
        // lets get the 4 corners of the rectangle
        double[][] corners = r.corners();

        for (double[] corner: corners) {
            if (!this.contains(corner[0], corner[1])) return false;
        }
        return true;
    }

    public boolean overlaps(MyRectangle2D r) {
        // lets get the 4 corners of the rectangle
        double[][] corners = r.corners();

        for (double[] corner: corners) {
            if (this.contains(corner[0], corner[1])) return true;
        }
        return false;
    }

}
