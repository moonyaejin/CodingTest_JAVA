import java.io.*;
import java.util.*;

public class Main {
    static int N, M, V;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 1. 입력 받기
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        // 2. 그래프 초기화
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        // 3. 간선 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a); // 양방향
        }

        // 4. 인접 리스트 정렬
        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }

        // 5. DFS 실행
        visited = new boolean[N + 1];
        dfs(V);
        System.out.println();

        // 6. BFS 실행
        visited = new boolean[N + 1];
        bfs(V);
    }

    // DFS (재귀)
    static void dfs(int node) {
        visited[node] = true;             // 현재 노드 방문 처리
        System.out.print(node + " ");
        for (int next : graph[node]) {    // 연결된 정점 순회
            if (!visited[next]) {         // 아직 방문하지 않은 정점이라면
                dfs(next);                // 재귀 호출
            }
        }
    }

    // BFS (큐)
    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        visited[start] = true;
        q.add(start);
        
        while(!q.isEmpty()) {
            int cur = q.poll();
            System.out.print(cur + " ");

            for (int next: graph[cur]) {     // 인접 노드 확인
                if (!visited[next]) {        // 아직 방문 안 했으면
                    visited[next] = true;    // 방문 처리
                    q.add(next);             // 큐에 추가
                }
            }
        }
    }
}
