import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        int[] result = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // 수열 입력
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            result[i] = -1;  // 결과 배열 기본값 -1로 초기화
        }
        
        Stack<Integer> stack = new Stack<>();  // 인덱스 저장 스택
        
        // 스택이 비어있지 않고, A[i]가 stack의 top 보다 크다면
        // 해당 인덱스의 오큰수는 현재 값 A[i]
        for (int i = 0; i < N; i++) {
            while(!stack.isEmpty() && A[i] > A[stack.peek()]) {
                // 오큰수 저장하고, 스택에서 인덱스 제거
                result[stack.pop()] = A[i];
            }
                stack.push(i);  // 현재 인덱스를 stack에 push
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(result[i]).append(" ");
        }
        
        System.out.println(sb);
    }
}