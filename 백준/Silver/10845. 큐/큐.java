import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        Queue<Integer> queue = new LinkedList<>();
        
        StringBuilder sb = new StringBuilder();  
        
        for (int i = 0; i < N; i++) {
            String command = br.readLine();
            
            if (command.startsWith("push")) {
                int x = Integer.parseInt(command.split(" ")[1]);  //"push X"에서 x 값 추출
                queue.offer(x);
            } else if (command.equals("pop")) {
                if (queue.isEmpty()) sb.append("-1\n");  // 큐가 비었으면 -1 출력
                else sb.append(queue.poll()).append("\n");  // 큐의 맨 앞 원소 제거
            } else if (command.equals("size")) {
                sb.append(queue.size()).append("\n");  // 현재 큐의 크기 출력
            } else if (command.equals("empty")) {
                sb.append(queue.isEmpty() ? "1\n" : "0\n");  // 비어있으면 1, 아니면 0 출력
            } else if (command.equals("front")) {
                sb.append(queue.isEmpty() ? "-1\n" : queue.peek() + "\n");  // 큐의 가장 앞 정수 출력
            } else if (command.equals("back")) {
                sb.append(queue.isEmpty() ? "-1\n" : ((LinkedList<Integer>)queue).getLast() + "\n");  // 큐의 가장 마지막 정수 출력
            }
        }
        System.out.print(sb.toString());
    }
}