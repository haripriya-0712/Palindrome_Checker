import java.util.Stack;
import java.util.Scanner;

class StackPalindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter string: ");
        String str = sc.nextLine();

        Stack<Character> stack = new Stack<>();

        for (char ch : str.toCharArray())
            stack.push(ch);

        boolean palindrome = true;

        for (char ch : str.toCharArray()) {
            if (ch != stack.pop()) {
                palindrome = false;
                break;
            }
        }

        if (palindrome)
            System.out.println("Palindrome");
        else
            System.out.println("Not Palindrome");
    }
}