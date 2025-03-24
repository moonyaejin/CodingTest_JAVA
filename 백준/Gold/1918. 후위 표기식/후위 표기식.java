import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        
        // 후기 표기 변환 로직
        // foreach문 - input 문자열을 문자 배열로 바꾼 후 그 배열의 각 문자 ch에 대해 반복 수행
        for (char ch : input.toCharArray()) {
            if (Character.isLetter(ch)) {
                result.append(ch);
            } else {
                switch (ch) {
                    case '(' :
                        stack.push(ch);
                        break;
                    case ')' :
                        // '(' 를 발견할 때 까지 스택에서 pop 후 출력
                        while (!stack.isEmpty() && stack.peek() != '(') {
                            result.append(stack.pop());
                        }
                        if (!stack.isEmpty() && stack.peek() == '(') {
                            stack.pop();  // '(' 를 버림
                        }
                        break;
                    case '+': case '-': case '*': case '/':
                        // stack이 비어있지 않고, stack의 top이 '('가 아니며, stack의 top 연산자의 우선순위가 높거나 같아면 스택에서 pop하여 출력
                        while (!stack.isEmpty() && stack.peek() != '(' && getPriority(stack.peek()) >= getPriority(ch)) {
                            result.append(stack.pop());
                        }
                        stack.push(ch);  // 현재 연산자 push
                        break;
                }
            }
        }    
        
        // 스택에 남아있는 연산자 출력
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        
        // 결과 출력
        System.out.println(result);
    }
    
    // 연산자 우선순위 반환 함수
    private static int getPriority(char op) {
        if (op == '+' || op == '-') return 1;
        if (op == '*' || op == '/') return 2;
        return 0;
    }
}