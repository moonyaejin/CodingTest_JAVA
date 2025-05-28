import java.util.Scanner;

public class Main {
    static final int MOD = 1000000000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        int[][] dp = new int[K + 1][N + 1];

        for (int i = 0; i <= K; i++) {
            dp[i][0] = 1; // j = 0일 때 모든 경우는 1
        }

        for (int i = 1; i <= K; i++) {
            for (int j = 1; j <= N; j++) {
                dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % MOD;
            }
        }

        System.out.println(dp[K][N]);
    }
}
