import java.util.*;
import java.io.*;

public class Main {
    // 정점 개수, 간선 개수, 시작 정점 번호
    static int N, M, V;

    static ArrayList<Integer>[] graph;

    // 방문 여부 체크
    static boolean[] visited;

    static List<Integer> dfsResult = new ArrayList<>();
    static List<Integer> bfsResult = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 정점 개수
        M = Integer.parseInt(st.nextToken()); // 간선 개수
        V = Integer.parseInt(st.nextToken()); // 시작 정점 번호

        // 인접 리스트 초기화
        graph = new ArrayList[N + 1]; // 정점 번호 1부터 사용
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            // 양방향 그래프 구성
            graph[n1].add(n2); 
            graph[n2].add(n1); 
        }

        // 각 정점의 인접 정점을 오름차순 정렬 (번호 작은 순서로 탐색하기 위해)
        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }

        // DFS 탐색 시작
        visited = new boolean[N + 1];
        dfs(V);
        printList(dfsResult);

        // BFS 탐색 시작
        visited = new boolean[N + 1]; 
        bfs(V);
        printList(bfsResult);
    }

    // 깊이 우선 탐색 (재귀)
    static void dfs(int v) {
        visited[v] = true;         // 현재 정점 방문 체크
        dfsResult.add(v);          // 방문한 정점을 결과 리스트에 추가

        // 인접 정점을 번호 순으로 탐색
        for (int next : graph[v]) {
            if (!visited[next]) {  // 아직 방문하지 않은 정점만 탐색
                dfs(next);
            }
        }
    }

    // 너비 우선 탐색 (큐)
    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;     // 시작 정점 방문 체크
        queue.offer(start);        // 시작 정점을 큐에 추가

        while (!queue.isEmpty()) {
            int current = queue.poll();     // 큐에서 정점을 꺼냄
            bfsResult.add(current);         // 방문한 정점을 결과 리스트에 추가

            // 인접 정점들을 순서대로 큐에 넣음
            for (int next : graph[current]) {
                if (!visited[next]) {       // 방문하지 않았다면
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }
    }

    static void printList(List<Integer> list) {
        for (int num : list) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
