import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // N 입력
        int N = sc.nextInt();

        // 수열 입력 받기
        int[] sequence = new int[N];
        for (int i = 0; i < N; i++) {
            sequence[i] = sc.nextInt();
        }

        // 스택 생성
        Stack<Integer> stack = new Stack<>();

        // 결과 저장
        StringBuilder sb = new StringBuilder();

        // 현재 push할 숫자
        int num = 1;

        // 수열 순회하며 알고리즘 구현
        for (int i = 0; i < N; i++) {
            int target = sequence[i];

            while (num <= target) {
                stack.push(num);
                sb.append("+\n");
                num++;
            }
            if (stack.peek() == target) {
                    stack.pop();
                    sb.append("-\n");
            } else { 
                System.out.println("NO");
                return;
            }
        }

        // 결과 출력
        System.out.print(sb.toString());
    }
}
