import java.util.Scanner;
    class Node {
        char data;
        Node next;

        Node(char data) {
            this.data = data;
            this.next = null;
        }


    public class PalindromeChecker {

        // Function to check palindrome using linked list
        public static boolean isPalindrome(String str) {

            Node head = null;
            Node tail = null;

            // Convert string to linked list
            for (char c : str.toCharArray()) {
                Node newNode = new Node(c);

                if (head == null) {
                    head = newNode;
                    tail = newNode;
                } else {
                    tail.next = newNode;
                    tail = newNode;
                }
            }

            // Find middle using fast and slow pointer
            Node slow = head;
            Node fast = head;

            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }

            // Reverse second half
            Node prev = null;
            Node current = slow;

            while (current != null) {
                Node next = current.next;
                current.next = prev;
                prev = current;
                current = next;
            }

            // Compare both halves
            Node firstHalf = head;
            Node secondHalf = prev;

            while (secondHalf != null) {
                if (firstHalf.data != secondHalf.data) {
                    return false;
                }
                firstHalf = firstHalf.next;
                secondHalf = secondHalf.next;
            }

            return true;
        }

        public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);

            System.out.println("=== Linked List Based Palindrome Checker ===");
            System.out.print("Enter a string: ");
            String input = scanner.nextLine();

            boolean result = isPalindrome(input);

            if (result) {
                System.out.println("The string is a Palindrome.");
            } else {
                System.out.println("The string is NOT a Palindrome.");
            }

            scanner.close();
        }
    }
}
