import java.util.*;

public class UseCase13PalindromeCheckerApp {


    public static boolean twoPointerPalindrome(String str) {
        int start = 0;
        int end = str.length() - 1;

        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }


    public static boolean reversePalindrome(String str) {
        String reversed = new StringBuilder(str).reverse().toString();
        return str.equals(reversed);
    }


    public static boolean stackPalindrome(String str) {
        Stack<Character> stack = new Stack<>();

        for (char c : str.toCharArray()) {
            stack.push(c);
        }

        for (char c : str.toCharArray()) {
            if (c != stack.pop()) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Palindrome Performance Comparison ===");
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();


        long start1 = System.nanoTime();
        boolean result1 = twoPointerPalindrome(input);
        long end1 = System.nanoTime();


        long start2 = System.nanoTime();
        boolean result2 = reversePalindrome(input);
        long end2 = System.nanoTime();


        long start3 = System.nanoTime();
        boolean result3 = stackPalindrome(input);
        long end3 = System.nanoTime();

        System.out.println("\nResults:");
        System.out.println("Two Pointer Method: " + result1 + " | Time: " + (end1 - start1) + " ns");
        System.out.println("StringBuilder Reverse: " + result2 + " | Time: " + (end2 - start2) + " ns");
        System.out.println("Stack Method: " + result3 + " | Time: " + (end3 - start3) + " ns");

        scanner.close();
    }
}