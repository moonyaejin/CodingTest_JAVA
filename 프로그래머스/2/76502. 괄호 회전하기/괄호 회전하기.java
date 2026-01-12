import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        // 문자열을 0부터 length-1번까지 회전
        for (int x = 0; x < s.length(); x++) {
            // 1. x칸 왼쪽으로 회전한 문자열 만들기
            String rotated = s.substring(x) + s.substring(0, x);
            
            // 2. 회전한 문자열이 올바른 괄호인지 검증
            if (isValid(rotated)) {
                answer++;
            }
        }
        
        return answer;
    }
    
    // 올바른 괄호인지 검증하는 메서드
    private boolean isValid(String str) {
        Stack<Character> stack = new Stack<>();
        
        // 문자열의 모든 문자를 순회
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            
            // 여는 괄호면 짝이 되는 닫는 괄호를 push
            if (c == '(') stack.push(')');
            else if (c == '{') stack.push('}');  // 뭘 넣어야 할까요?
            else if (c == '[') stack.push(']');  
            // 닫는 괄호면
            else {
                // 스택이 비었거나, pop한 값이 현재 문자와 다르면
                if (stack.isEmpty() || stack.pop() != c) {
                    return false;
                }
            }
        }
        
        // 모든 검증이 끝난 후 스택이 비어있어야 올바른 괄호
        return stack.isEmpty();
    }
}