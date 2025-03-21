import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        // 최대 힙
        PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());
        
        // 최소 힙
        PriorityQueue<Integer> right = new PriorityQueue<>();
        
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            
            // 새로운 수를 left에 넣음
            left.add(num);
            
            // rigth가 비어있지 않고, left의 TOP > rigth의 TOP 이라면, left의 top을 꺼내 rigth에 넣음
            if (!right.isEmpty() && left.peek() > right.peek()) {
                right.add(left.poll());
            }
            
            // 힙의 크기 균형 맞춤
            if (left.size() > right.size() + 1) {
                right.add(left.poll());
            } else if (right.size() > left.size()) {
                left.add(right.poll());
            }
            
            System.out.println(left.peek());
        }
    }
}