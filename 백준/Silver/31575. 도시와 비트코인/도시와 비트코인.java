import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[][] city;
    static boolean[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        city = new int[M][N];
        dp = new boolean[M][N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                city[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = true;

        for (int y = 0; y < M; y++) {
            for (int x = 0; x < N; x++) {
                if (city[y][x] == 1) {
                    if (y > 0 && dp[y - 1][x]) dp[y][x] = true;
                    if (x > 0 && dp[y][x - 1]) dp[y][x] = true;
                }
            }
        }

        System.out.println(dp[M - 1][N - 1] ? "Yes" : "No");
    }
}
