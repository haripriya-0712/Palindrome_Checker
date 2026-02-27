public class PalindromeCheckerApp {

    public static void main(String[] args) {
        String word = "radar";
        char[] ch = word.toCharArray();
        int start = 0;
        int end = ch.length - 1;
        boolean isPalindrome = true;
        while (start < end) {
            if (ch[start] != ch[end]) {
                isPalindrome = false;
                break;
            }
            start++;
            end--;
        }
        if (isPalindrome) {
            System.out.println(word + " is Palindrome");
        } else {
            System.out.println(word + " is not a Palindrome");
        }
    }
}