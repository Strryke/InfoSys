package pset;

public class Fibonacci {
    public static void main(String[] args) {
        String output = fibonacci(10);
        System.out.println(output);
    }

    public static String fibonacci( int n ) {
        String output = "";
        int a = 0, b = 1;
        for (int i = 0; i < n; i++) {
            output += a;
            int c = a + b;
            a = b;
            b = c;

            if (i != n - 1) {
                output += ",";
            }
        }

        return output;
    }
}
