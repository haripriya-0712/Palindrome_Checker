import java.util.*;

public class PalindromeCheckerApp{

    static boolean twoPointer(String str) {
        int left = 0, right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }

    static boolean stackMethod(String str) {
        Stack<Character> stack = new Stack<>();
        for (char c : str.toCharArray())
            stack.push(c);

        for (char c : str.toCharArray())
            if (c != stack.pop())
                return false;

        return true;
    }

    static boolean dequeMethod(String str) {
        Deque<Character> deque = new ArrayDeque<>();
        for (char c : str.toCharArray())
            deque.addLast(c);

        while (deque.size() > 1)
            if (!deque.removeFirst().equals(deque.removeLast()))
                return false;

        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        long start, end;

        start = System.nanoTime();
        boolean r1 = twoPointer(input);
        end = System.nanoTime();
        System.out.println("Two Pointer Time: " + (end - start) + " ns");

        start = System.nanoTime();
        boolean r2 = stackMethod(input);
        end = System.nanoTime();
        System.out.println("Stack Method Time: " + (end - start) + " ns");

        start = System.nanoTime();
        boolean r3 = dequeMethod(input);
        end = System.nanoTime();
        System.out.println("Deque Method Time: " + (end - start) + " ns");

        sc.close();
    }
}
