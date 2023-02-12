package pset;

public class PrimeNumberChecker {
    public static void main(String[] args) {
        int[] cases = {4, 7, 14, 23, 99};
        for (int i : cases) {
            System.out.println((isPrime(i)));

        }
    }

    public static int isPrime(int num) {
        for (int i = 2; i < num; i++) {
            if (num % i == 0) return 0;
        }
        return 1;
    }
}
