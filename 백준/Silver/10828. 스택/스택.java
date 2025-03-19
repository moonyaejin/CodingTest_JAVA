import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine()); 
        
        // 스택 역할을 할 List
        List<Integer> stack = new ArrayList<>();  
        
        StringBuilder sb = new StringBuilder();  
        
        // N번의 명령어를 처리하는 반복문
        for (int i = 0; i < N; i++) {
            String command = br.readLine();  // 한 줄 입력받기
            
            if (command.startsWith("push")) {
                int x = Integer.parseInt(command.split(" ")[1]); // "push X"에서 X 값 추출
                stack.add(x);  // 스택에 X 추가
            } 
            
            else if (command.equals("pop")) {
                if (stack.isEmpty()) sb.append("-1\n");  // 스택이 비었으면 -1 출력
                else sb.append(stack.remove(stack.size() - 1)).append("\n"); // 마지막 요소 제거 후 출력
            } 
            
            else if (command.equals("size")) {
                sb.append(stack.size()).append("\n");  // 현재 스택 크기 출력
            } 
            
            else if (command.equals("empty")) {
                sb.append(stack.isEmpty() ? "1\n" : "0\n");  // 비어있으면 1, 아니면 0 출력
            } 
            
            else if (command.equals("top")) {
                if (stack.isEmpty()) sb.append("-1\n");  // 스택이 비었으면 -1 출력
                else sb.append(stack.get(stack.size() - 1)).append("\n"); // 스택의 마지막 요소 출력
            }
        }
        
        // 최적화된 출력을 위해 한 번에 출력
        System.out.print(sb.toString());
        
        // BufferedReader 닫기 (자원 해제)
        br.close();
    }
}
