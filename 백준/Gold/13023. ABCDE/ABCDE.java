import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static boolean found = false;   // 조건 충족 여부
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());   // 사람 수
        M = Integer.parseInt(st.nextToken());   // 친구 관계 수

        graph = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }

        // 간선 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            dfs(i, 0);
            if (found) break;
        }

        System.out.println(found ? 1 : 0);
    }

    static void dfs(int cur, int depth) {
        if (found) return;
        if (depth == 4) {   // 이미 찾았으면 더 이상 탐색할 필요 없음
            found = true;   // 깊이가 4라면 A-B-C-D-E 형태가 완성된 것
            return;
        }
    visited[cur] = true;    // 현재 정점을 방문 처리 (다른 경로에서 재사용하기 위해 백트래킹)
        for (int next : graph[cur]) {
            if (!visited[next]) {
                dfs(next, depth + 1);
                // 하위 호출에서 found가 true가 되었으면 현재 노드의 visited를 해제하고 즉시 반환
                if (found) {
                    visited[cur] = false;
                    return;
                }
            }
        }
        visited[cur] = false;   // 백트래킹: 다른 시작점/경로를 위해 방문 해제
    }
}