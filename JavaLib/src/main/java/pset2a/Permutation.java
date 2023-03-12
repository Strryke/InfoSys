package pset2a;


import java.util.ArrayList;

public class Permutation {
    private final String in;
    private ArrayList<String> a = new ArrayList<String>();
    // additional attribute if needed



    Permutation(final String str){
        in = str;
        // additional initialization if needed

    }

    public void permute() {
        permuter("", in);
    }

    private void permuter(String prefix, String suffix) {
        int n = suffix.length();
        if (n == 0) {
            a.add(prefix);
        } else {
            for (int i = 0; i < n; i++) {
                permuter(prefix + suffix.charAt(i), suffix.substring(0, i) + suffix.substring(i+1, n));
            }
        }
    }


    public ArrayList<String> getA(){
        return a;
    }
}

