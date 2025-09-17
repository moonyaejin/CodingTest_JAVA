import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<Integer>[] tree;
    static boolean[] visited;
    static int[] parent;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        tree = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        // 간선은 N-1개
        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            tree[u].add(v);
            tree[v].add(u);
        }

        visited = new boolean[N + 1];
        parent = new int[N + 1];

        // 루트는 1
        visited[1] = true;
        dfs(1);

        // 2번 노드부터 부모 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= N; i++) {
            sb.append(parent[i]).append("\n");
        }
        System.out.print(sb);
    }

    static void dfs(int node) {
        for (int next : tree[node]) {
            if (!visited[next]) {
                visited[next] = true;
                parent[next] = node;  // 부모 기록
                dfs(next);
            }
        }
    }
}
