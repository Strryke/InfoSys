package pset;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Iterating {
    public static void main(String[] args) {
        // Adjust this value
        int n = 10;
        // Or use this instead if you are passing command-line arguments
        // int n = Integer.parseInt(args[0]);

        // Generate the input ArrayList
        List<Integer> integerList = new ArrayList<>();
        for( int i = 1; i <= n; i++){
            integerList.add(i);
        }

        //Recall that 1 + 2 + .. + n = n(n+1)/2.
        String ans = "" + Act2Iterator(integerList);
        ans = "Iterator Sum = " + ans;
        System.out.println(ans);
    }

    public static int Act2Iterator(List<Integer> integers) {
        int sum = 0;

        // using for loop
//        for (int i = 0; i < integers.size(); i++) {
//            sum += integers.get(i);
//        }

        // using the iterator object
//        Iterator<Integer> iter = integers.iterator();
//
//        while (iter.hasNext()) {
//            sum += iter.next();
//        }

        // using for-each
        for (int e: integers) {
            sum += e;
        }

        return sum;
    }
}
