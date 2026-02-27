import java.util.*;

class Node {
    char data;
    Node next;

    Node(char data) {
        this.data = data;
    }
}

public class PalinderomeCheckerApp {

    static Node reverse(Node head) {
        Node prev = null;
        Node curr = head;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    static boolean isPalindrome(Node head) {
        if (head == null || head.next == null)
            return true;

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node second = reverse(slow);
        Node first = head;

        while (second != null) {
            if (first.data != second.data)
                return false;
            first = first.next;
            second = second.next;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        Node head = null, tail = null;

        for (char ch : str.toCharArray()) {
            Node n = new Node(ch);
            if (head == null) {
                head = tail = n;
            } else {
                tail.next = n;
                tail = n;
            }
        }

        if (isPalindrome(head))
            System.out.println("Palindrome");
        else
            System.out.println("Not a Palindrome");

        sc.close();
    }
}