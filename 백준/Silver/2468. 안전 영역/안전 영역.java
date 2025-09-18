import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[][] area;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        area = new int[N][N];
        int maxHeight = 0; // 입력 중 가장 높은 지형 찾기

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                area[i][j] = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(maxHeight, area[i][j]);
            }
        }

        int result = 0;
        for (int h = 0; h <= maxHeight; h++) { // 강수량 0 ~ 최고 높이까지 시뮬레이션
            visited = new boolean[N][N];
            int count = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j] && area[i][j] > h) {
                        dfs(i, j, h);
                        count++;
                    }
                }
            }

            result = Math.max(result, count);
        }

        System.out.println(result);
    }

    static void dfs(int x, int y, int h) {
        visited[x][y] = true;

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                if (!visited[nx][ny] && area[nx][ny] > h) {
                    dfs(nx, ny, h);
                }
            }
        }
    }
}
