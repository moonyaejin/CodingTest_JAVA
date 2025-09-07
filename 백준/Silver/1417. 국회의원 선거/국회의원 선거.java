import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // 첫째 줄에 후보의 수 N이 주어진다. 
        // 둘째 줄부터 차례대로 기호 1번을 찍으려고 하는 사람의 수, 기호 2번을 찍으려고 하는 수, 이렇게 총 N개의 줄에 걸쳐 입력이 들어온다. 
        // N은 50보다 작거나 같은 자연수이고, 득표수는 100보다 작거나 같은 자연수이다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int answer = 0;
        
        int dasom = Integer.parseInt(br.readLine());

        // pq.peek()이 항상 가장 큰 값(현재 최다 득표자 표 수)
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 1; i < N; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }

        // 다솜이보다 득표수가 많거나 같을 때
        while(!pq.isEmpty() && pq.peek() >= dasom) {
            int x = pq.poll();   // 가장 득표수가 높은 후보 꺼냄
            x--;
            dasom++;
            answer++;

            pq.add(x);          // 다시 큐에 넣어줌
        }

        System.out.println(answer);
    }
}