import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 공간의 크기 입력
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        int startX = 0, startY = 0;

        // 공간 상태 입력 + 아기 상어의 시작 위치 찾기
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                // 상어 위치
                if (map[i][j] == 9) {
                    startX = i;
                    startY = j;
                    map[i][j] = 0; // 상어가 있던 자리는 빈 칸으로 초기화
                }
            }
        }

        // 상어 크기
        int sharkSize = 2;
        // 먹이 먹은 횟수
        int eatCount = 0;
        // 총 이동 시간
        int totalTime = 0;
        // 현재 상어 위치
        int sharkX = startX, sharkY = startY;

        // 더 이상 먹을 수 있는 물고기가 없을 때까지 반복
        while (true) {
            Fish target = findNearestFish(map, sharkX, sharkY, sharkSize);
            // 물고기 없으면 엄마 상어에게 도움 요청
            if (target == null) break;

            // 상어 위치 갱신
            sharkX = target.x;
            sharkY = target.y;
            // 이동한 거리만큼 시간 추가
            totalTime += target.dist;

            // 물고기 먹기
            eatCount++;
            if (eatCount == sharkSize) {
                // 먹은 수가 크기와 같아지면 상어 크기 증가
                sharkSize++;
                eatCount = 0;
            }

            // 상어가 이동하고 물고기를 먹었으니 빈칸
            map[sharkX][sharkY] = 0;
        }

        // 총 걸린 시간 출력
        System.out.println(totalTime);
    }

    // 가장 가까운 물고기 찾기 (BFS 탐색)
    static Fish findNearestFish(int[][] map, int sharkX, int sharkY, int sharkSize) {
        int N = map.length;
        // 이 칸을 이미 방문했는지 체크 (중복 방문 방지)
        boolean[][] visited = new boolean[N][N];
        // BFS 탐색에 사용
        Queue<Node> queue = new LinkedList<>();
        // 탐색 도중 먹을 수 있는 물고기 후보를 담아두는 리스트
        List<Fish> fishList = new ArrayList<>();

        // 상, 좌, 우, 하 우선 탐색 (우선순위 조건 맞추기 위해 이 순서 사용)
        int[] dx = {-1, 0, 0, 1};  // 상하
        int[] dy = {0, -1, 1, 0};  // 좌우

        // 시작점 큐에 삽입
        queue.offer(new Node(sharkX, sharkY, 0));  // 상어의 현재 위치, 상어가 이동한 거리를 큐에 넣음
        visited[sharkX][sharkY] = true;  // 시작점은 이미 큐에 넣었으니 중복 탐색하지 않도록 방문 표시

        // 지금까지 발견한 먹을 수 있는 물고기 중 가장 가까운 거리 저장
        // 처음엔 아무것도 못 찾은 상태이므로, MAX_VALUE로 초기화
        int minDist = Integer.MAX_VALUE;

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            // 현재 거리보다 더 먼 노드는 확인할 필요 없음
            // 이미 더 가까운 물고기를 찾았기 때문에 불필요한 탐색을 줄이기 위해 break
            if (current.dist > minDist) break;

            // 4방향 탐색
            // d = 0 위 d = 1 왼쪽 d = 2 오른쪽 d = 3 아래 (4방향 모두 검사)
            for (int d = 0; d < 4; d++) {
                // 다음 위치 계산
                // nx, ny = 현재 상어 위치 + 그 방향으로 한칸 이동한 위치
                int nx = current.x + dx[d];
                int ny = current.y + dy[d];

                // 범위 벗어나거나 방문했거나, 못 지나가는 칸이면 skip
                // nx < 0 이면 위로 벗어났다는 뜻
                // ny < 0 이면 왼쪽으로 벗어났다는 뜻
                // nx >= N 이면 아래로 벗어났다는 뜻
                // ny >= N 이면 오른쪽으로 벗어났다는 뜻
                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;

                // 이미 갔던 칸이면 한 번 더 갈 필요가 없음
                if (visited[nx][ny]) continue;
                if (map[nx][ny] > sharkSize) continue; // 상어보다 큰 물고기는 못 지나감

                // 이동 가능한 칸이라고 확인했으면 방문했다고 체크하고 큐에 넣음
                visited[nx][ny] = true;
                queue.offer(new Node(nx, ny, current.dist + 1));  // 지금까지 걸어온 거리 + 1 -> 여기로 오려면 몇 칸 이동했는지

                // 물고기가 있는 칸 && 상어보다 작으면 먹을 수 있는 물고기 리스트에 저장
                if (map[nx][ny] > 0 && map[nx][ny] < sharkSize) {
                    fishList.add(new Fish(nx, ny, current.dist + 1));
                    minDist = current.dist + 1; // 가장 가까운 거리 갱신. 이 거리보다 먼 애들은 볼 필요 X
                }
            }
        }

        // 먹을 수 있는 물고기가 없다면 null 리턴
        if (fishList.isEmpty()) return null;

        // 거리순 → 위쪽(행 작은 순) → 왼쪽(열 작은 순) 우선 정렬
        fishList.sort((f1, f2) -> {
            if (f1.dist != f2.dist) return f1.dist - f2.dist;
            if (f1.x != f2.x) return f1.x - f2.x;
            return f1.y - f2.y;
        });

        // 가장 우선순위 높은 물고기 리턴
        return fishList.get(0);
    }

    // BFS 탐색용 노드 클래스
    static class Node {
        int x, y, dist;
        Node(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    // 먹을 수 있는 물고기 정보 클래스
    static class Fish {
        int x, y, dist;
        Fish(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
}
