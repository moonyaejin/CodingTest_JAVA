import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 1. 입력 받기
        String[] input = br.readLine().split(" ");
        int T = Integer.parseInt(input[0]); // 전체 시간
        int W = Integer.parseInt(input[1]); // 최대 이동 횟수

        // 2. 자두가 떨어지는 위치 저장 (1초부터 시작하기 위해 +1)
        int[] drop = new int[T + 1];
        for (int i = 1; i <= T; i++) {
            drop[i] = Integer.parseInt(br.readLine());
        }

        // 3. DP 배열 선언
        int[][] dp = new int[T + 1][W + 1];

        // 4. DP 점화식 작성
        for (int t = 1; t <= T; t++) {
            for (int w = 0; w <= W; w++) {
                // 현재 위치 계산 (w가 짝수면 1번 나무, 홀수면 2번 나무)
                int currentPos = (w % 2 == 0) ? 1 : 2;
                    
                // 받을 수 있는지 확인
                // 이동하지 않고 자두 받기 여부
                if (dp[t][w] < dp[t - 1][w]) {
                    dp[t][w] = dp[t - 1][w];
                }
                if (drop[t] == currentPos) {
                    dp[t][w]++;
                }

                // 이동해서 자두 받기 (w > 0인 경우에만)
                if (w > 0) {
                    int prevPos = (w % 2 == 0) ? 2 : 1; // 이전 위치
                    int temp = dp[t - 1][w - 1];
                    if (drop[t] == currentPos) {
                        temp++;
                    }
                    dp[t][w] = Math.max(dp[t][w], temp);
                }
            }
        }

        // 5. 최대 자두 개수 구하기
        int max = 0;
        for (int w = 0; w <= W; w++) {
            max = Math.max(max, dp[T][w]);
        }

        // 6. 결과 출력
        System.out.println(max);
    }
}
