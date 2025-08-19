import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] board;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 게임 구역 크기 입력
        N = Integer.parseInt(br.readLine());

        // 게임판 입력
        board = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // DFS 실행
        if (dfs(0, 0)) {
            System.out.println("HaruHaru");
        } else {
            System.out.println("Hing");
        }
    }

    // DFS 함수 (로직은 채워야 함)
    static boolean dfs(int x, int y) {
        // 범위 밖이면 패배
        if (x < 0 || x >= N || y < 0 || y >= N) return false;

        // 이미 방문한 칸이면 종료
        if (visited[x][y]) return false;

        // 도착 지점 -1이면 성공
        if (board[x][y] == -1) return true;

        // 현재 칸 방문 처리
        visited[x][y] = true;

        // 현재 칸 이동 거리
        int move = board[x][y];

        // 오른쪽으로 이동
        if (dfs(x, y + move)) return true;

        // 아래로 이동
        if (dfs(x + move, y)) return true;

        return false;
    }
}
