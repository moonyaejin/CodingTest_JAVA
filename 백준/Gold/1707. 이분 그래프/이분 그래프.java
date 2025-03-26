import java.util.*;
import java.io.*;

public class Main {

  static ArrayList<Integer>[] graph;

    // 정점의 색 저장 (0: 미방문, 1: 빨강, -1: 파랑)
    static int[] color;

    static boolean isBipartite;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 테스트 케이스 개수 입력
        int k = Integer.parseInt(br.readLine());

        // 각 테스트 케이스마다 실행
        while (k-- > 0) {
            // 정점 수 V, 간선 수 E 입력
            StringTokenizer st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());  // 정점 수
            int e = Integer.parseInt(st.nextToken());  // 간선 수

            // 그래프 및 색 배열 초기화
            graph = new ArrayList[v + 1]; // 인덱스 1부터 사용
            color = new int[v + 1];

            // 각 정점에 대한 리스트 생성
            for (int i = 1; i <= v; i++) {
                graph[i] = new ArrayList<>();
            }

            // 간선 정보 입력 및 양방향 연결
            for (int i = 0; i < e; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());

                graph[u].add(w);
                graph[w].add(u); // 양방향 간선
            }

            isBipartite = true;

            // 연결되지 않은 그래프를 위해 모든 정점 검사
            for (int i = 1; i <= v; i++) {
                if (color[i] == 0) { // 방문하지 않은 정점이면
                    bfs(i);         // BFS 탐색 시작
                    if (!isBipartite) break; // 이분 그래프가 아니면 종료
                }
            }

            System.out.println(isBipartite ? "YES" : "NO");
        }
    }

    // BFS를 이용한 이분 그래프 판별 함수
    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);       // 시작 정점을 큐에 넣음
        color[start] = 1;         // 시작 정점을 빨강(1)으로 칠함

        // 큐가 빌 때까지 반복
        while (!queue.isEmpty()) {
            int now = queue.poll(); // 현재 정점 꺼내기

            // 현재 정점과 연결된 모든 이웃 정점 확인
            for (int next : graph[now]) {
                if (color[next] == 0) {
                    // 아직 방문하지 않은 정점이면, 현재 정점의 반대 색으로 칠함
                    color[next] = -color[now];
                    queue.offer(next);
                } else if (color[next] == color[now]) {
                    // 이미 방문했는데, 현재 정점과 같은 색이면 이분 그래프 아님
                    isBipartite = false;
                    return;
                }
            }
        }
    }
}
