import java.util.*;

class Solution {
    public int solution(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty() || s.charAt(i) != stack.peek()) {
                stack.push(s.charAt(i));
            }
            else { 
                stack.pop();
            }
        }
        if (stack.isEmpty()) {
            return 1;
        } else return 0;
    }
}