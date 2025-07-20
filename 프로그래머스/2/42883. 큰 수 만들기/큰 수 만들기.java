import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        String number = "1924";
        int k = 2;
        System.out.println(solution(number, k));
    }

    public static String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < number.length(); i++) {
            char current = number.charAt(i);

            while(!stack.isEmpty() && k > 0 && stack.peek() < current) {
                stack.pop();
                k--;
            }
            stack.push(current);
        }

        while(k > 0) {
            stack.pop();
            k--;
        }

        for(char digit : stack) {
            sb.append(digit);
        }
        return sb.toString();
    }
}
