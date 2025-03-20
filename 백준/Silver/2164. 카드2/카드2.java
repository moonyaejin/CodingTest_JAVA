import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        Queue<Integer> queue = new LinkedList<>();
     
        for (int i = 1; i <= N; i++) {
            queue.offer(i);
        }
        
        // 카드 버리고 이동
        while (queue.size() > 1) {
            queue.poll();  // 맨 위 카드(맨 앞)를 버림
            queue.offer(queue.poll());  // 맨위 - 1 카드를 빼서 맨 아래(맨 뒤)로 보냄
        }
        
        System.out.println(queue.poll());
    }
}