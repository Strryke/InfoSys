package pset2a;

public class Octagon implements Comparable<Octagon> {

    private double side;

    public Octagon(double side) {
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    @Override
    public int compareTo(Octagon o) {
        double thisPerimeter = 8 * this.side;
        double otherPerimeter = 8 * o.side;
        if (thisPerimeter < otherPerimeter) {
            return -1;
        } else if (thisPerimeter > otherPerimeter) {
            return 1;
        } else {
            return 0;
        }
    }
}
