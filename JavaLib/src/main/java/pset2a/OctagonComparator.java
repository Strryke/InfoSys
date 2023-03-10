package pset2a;

import java.util.Comparator;

public class OctagonComparator implements Comparator<Octagon> {

    @Override
    public int compare(Octagon o, Octagon t1) {
        return (int) (o.getSide() - t1.getSide());
    }
}
