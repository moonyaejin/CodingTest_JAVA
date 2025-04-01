import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] originalMap;
    static int maxSafe = 0;
    static List<Point> blank = new ArrayList<>();
    static List<Point> virus = new ArrayList<>();
    static int[] dx = {-1, 1, 0, 0}; // 상하좌우
    static int[] dy = {0, 0, -1, 1};

    static class Point {
        int x, y;
        Point(int x, int y) { this.x = x; this.y = y; }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        originalMap = new int[N][M];

        // 입력 + 빈 칸/바이러스 좌표 저장
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                originalMap[i][j] = Integer.parseInt(st.nextToken());
                if (originalMap[i][j] == 0) blank.add(new Point(i, j));
                else if (originalMap[i][j] == 2) virus.add(new Point(i, j));
            }
        }

        // 벽 3개 세우는 모든 조합 실행
        makeWalls(0, 0, new Point[3]);

        System.out.println(maxSafe);
    }

    // 벽 조합 생성 
    // selected는 3개의 벽 좌표를 저장 할 배열
    // depth는 현재까지 선택한 벽의 개수
    // start는 중복 없는 조합 생성을 위한 시작 인덱스
    static void makeWalls(int start, int depth, Point[] selected) {
        // 벽 3개를 다 고르면 simulate. 재귀 탈출
        if (depth == 3) {
            simulate(selected);
            return;
        }

        // 지도에서 0인 칸의 사이즈만큼 반복
        // 0인 곳에 벽을 세울 수 있기 때문에
        /* 아래와 같은 흐름
        makeWalls(0, 0, selected); // 처음 호출
         → selected[0] = blank[0]; → makeWalls(1, 1, selected)
           → selected[1] = blank[1]; → makeWalls(2, 2, selected)
              → selected[2] = blank[2]; → makeWalls(3, 3, selected)
                 → depth == 3 → simulate(selected)
                 */
        for (int i = start; i < blank.size(); i++) {
            // 빈칸 하나의 좌표를 가져와 현재 벽으로 임시 저장
            selected[depth] = blank.get(i);
            makeWalls(i + 1, depth + 1, selected);
        }
    }

    static void simulate(Point[] walls) {
        // 원본을 지키기 위해 지도 복사
        int[][] map = copyMap();

        // selected로 전달받은 3개의 위치에 벽(1) 세우기 -> map의 해당 위치를 1로 바꿈
        for (Point wall : walls) {
            map[wall.x][wall.y] = 1;
        }

        Queue<Point> queue = new LinkedList<>();
        
        // 이미 방문한 위치를 저장해 중복 탐색 방지
        boolean[][] visited = new boolean[N][M];

        // virus 리스트에 2로 표시된 바이러스 위치들이 저장되어 있음.
        // 이걸 큐에 전부 넣고 방문 체크
        for (Point v : virus) {
            queue.add(v);
            visited[v.x][v.y] = true;
        }

        while (!queue.isEmpty()) {
            Point p = queue.poll();
            
            // 상하좌우로 이동할 좌표 계산
            for (int d = 0; d < 4; d++) {
                int nx = p.x + dx[d];
                int ny = p.y + dy[d];

                // (nx, ny) 좌표가 맵 안에 있고 && 아직 방문하지 않았고 %% 위치가 0이면
                if (isIn(nx, ny) && !visited[nx][ny] && map[nx][ny] == 0) {

                    // 바이러스가 퍼짐
                    map[nx][ny] = 2;

                    // 방문 처리
                    visited[nx][ny] = true;

                    // 이 위치를 다시 큐에 넣고 바이러스를 퍼뜨림
                    queue.add(new Point(nx, ny));
                }
            }
        }

        // 안전 영역 계산
        int safe = 0;

        // 이중 for문으로 map의 모든 칸을 순회
        for (int[] row : map) {
            for (int val : row) {

                // val==0인 안전한 칸만 카운트
                if (val == 0) safe++;
            }
        }
        // 지금까지 구한 안전한 칸 크기와 비교해 더 큰 값을 maxSafe에 저장
        maxSafe = Math.max(maxSafe, safe);
    }

    static int[][] copyMap() {
        int[][] newMap = new int[N][M];
        for (int i = 0; i < N; i++) {
            newMap[i] = originalMap[i].clone();  // 각 행 복제
        }
        return newMap;
    }

    // 좌표가 현재 연구소 지도 범위 안에 있는지 확인
    static boolean isIn(int x, int y) {

        // 위로 벗어나지 않고 && 아래로 벗어나지 않고 && 왼쪽으로 벗어나지 않고 && 오른쪽으로 벗어나지 않음
        return x >= 0 && x < N && y >= 0 && y < M;
    }
}
