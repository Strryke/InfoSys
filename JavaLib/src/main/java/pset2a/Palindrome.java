package pset2a;

public class Palindrome {
    public static void main(String[] args) {
        char[] str = {'a', 's'};
        System.out.println(isPalindrome(str));
    }
    public static boolean isPalindrome(char[] arr) {
        return isPalindromeHelper(arr, 0, arr.length - 1);
    }

    private static boolean isPalindromeHelper(char[] arr, int left, int right) {
        if (left >= right) {
            return true;
        } else if (arr[left] != arr[right]) {
            return false;
        } else {
            return isPalindromeHelper(arr, left + 1, right - 1);
        }
    }
}

