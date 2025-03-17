import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int L = sc.nextInt();
        sc.close();

        for (int len = L; len <= 100; len++) {
            long sumL = (long) len * (len - 1) / 2; // 등차수열의 합 공식 적용
            
            if (N < sumL) continue; // N보다 합이 크면 불가능

            long start = (N - sumL) / len; // 시작 숫자 계산
            
            if ((N - sumL) % len == 0 && start >= 0) { // 정수인지 확인 & 음수 아닌지 확인
                for (int i = 0; i < len; i++) {
                    System.out.print((start + i) + " ");
                }
                return; // 가장 짧은 수열을 찾으면 종료
            }
        }

        System.out.println(-1); // 가능한 수열이 없으면 -1 출력
    }
}
