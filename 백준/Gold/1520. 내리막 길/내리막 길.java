import java.util.*;
import java.io.*;

public class Main {
    static int M, N;
    static int[][] map;
    static int[][] dp;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[M][N];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp = new int[M][N];
        for (int i = 0; i < M; i++) Arrays.fill(dp[i], -1);   // dp 배열을 -1로 초기화(메모이제이션 : 중복 계산 방지)

        System.out.println(dfs(0, 0));
    }

    static int dfs(int x, int y) {
        if (x == M - 1 && y == N - 1) return 1; // 도착지
        if (dp[x][y] != -1) return dp[x][y];

        dp[x][y] = 0;   // 초기화: 이 위치에서 도착지로 갈 수 있는 경로 수

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx < 0 || ny < 0 || nx >= M || ny >= N) continue;
            // 이동할 곳이 지금보다 낮을 때만 DFS 재귀 호출
            if (map[nx][ny] < map[x][y]) {
                dp[x][y] += dfs(nx, ny);
            }
        }
        return dp[x][y];
    }
}