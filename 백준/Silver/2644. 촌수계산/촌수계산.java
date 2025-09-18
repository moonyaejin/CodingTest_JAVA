import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int answer = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine()); // 전체 사람 수

        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken()); // 촌수 계산할 사람 1
        int b = Integer.parseInt(st.nextToken()); // 촌수 계산할 사람 2

        int m = Integer.parseInt(br.readLine()); // 관계 수

        graph = new ArrayList[n + 1];
        visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            // 부모-자식 관계는 양방향 저장
            graph[x].add(y);
            graph[y].add(x);
        }

        dfs(a, b, 0);

        System.out.println(answer);
    }

    static void dfs(int current, int target, int count) {
        if (current == target) {
            answer = count;
            return;
        }

        visited[current] = true;

        for (int next : graph[current]) {
            if (!visited[next]) {
                dfs(next, target, count + 1);
            }
        }
    }
}
