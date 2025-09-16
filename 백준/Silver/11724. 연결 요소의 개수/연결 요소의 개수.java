import java.util.*;
import java.io.*;

public class Main {
    // 그래프를 인접 리스트 형태로 저장할 배열
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    // 정점 개수 N, 간선 개수 M
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 그래프 초기화
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        // M개의 간선 입력 받기
        // 방향 없는 그래프이므로 양쪽에 다 추가
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()); // 간선의 한쪽 정점
            int v = Integer.parseInt(st.nextToken()); // 간선의 다른쪽 정점
            graph[u].add(v);
            graph[v].add(u);
        }

        // 방문 배열 초기화
        visited = new boolean[N + 1];
        int count = 0; // 연결 요소 개수

        // 모든 정점에 대해 탐색 시도
        for (int i = 1; i <= N; i++) {
            // 아직 방문하지 않은 정점이면 새로운 연결 요소 시작
            if (!visited[i]) {
                dfs(i);   // 그 정점을 시작으로 DFS 탐색
                count++;  // DFS 한 번 끝나면 연결 요소 1개 발견
            }
        }

        // 최종 연결 요소 개수 출력
        System.out.println(count);
    }

    static void dfs(int node) {
        visited[node] = true; // 현재 정점 방문 처리

        // 현재 정점에 인접한 정점들 확인
        for (int next : graph[node]) {
            // 아직 방문하지 않은 정점이면 DFS 재귀 호출
            if (!visited[next]) {
                dfs(next);
            }
        }
    }
}
