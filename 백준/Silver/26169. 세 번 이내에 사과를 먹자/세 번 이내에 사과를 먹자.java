import java.util.*;
import java.io.*;

public class Main {
    static int[][] board = new int[5][5];
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 보드 입력
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 시작 위치 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        dfs(r, c, 0, 0);

        System.out.println(answer);
    }

    static void dfs(int r, int c, int move, int apple) {
        if (apple >= 2) {
            answer = 1;
            return;
        }

        if (move >= 3 || answer == 1) return;

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        for (int d = 0; d < 4; d++) {
            int nr = r + dx[d];
            int nc = c + dy[d];

            // 보드 범위 체크
            if (nr < 0 || nr >= 5 || nc < 0 || nc >= 5) continue;

            // 장애물이면 못 감
            if (board[nr][nc] == -1) continue;

            // 현재 칸 막기
            int temp = board[r][c];
            board[r][c] = -1;

            // 사과면 apple+1
            dfs(nr, nc, move + 1, apple + (board[nr][nc] == 1 ? 1 : 0));

            // 원래대로 복구
            board[r][c] = temp;
        }
    }
}
