import java.util.Scanner;

public class Main {
    static final int MOD = 10007;
    static int[][] dp = new int[1001][1001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        for (int n = 0; n <= N; n++) {
            for (int k = 0; k <= n; k++) {
                if (k == 0 || k == n) {
                    dp[n][k] = 1;
                } else {
                    dp[n][k] = (dp[n - 1][k - 1] + dp[n - 1][k]) % MOD;
                }
            }
        }

        System.out.println(dp[N][K]);
    }
}
