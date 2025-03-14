import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<ArrayList<Integer>> graph;
    static int[] amounts;
    static int n, visit;

    // 최대공약수(GCD) 구하기 (유클리드 호제법)
    static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    // DFS로 비율 적용
    static void dfs(int node, int mul) {
        amounts[node] *= mul;
        visit |= (1 << node); // 방문 체크 (비트마스크 활용)

        for (int next : graph.get(node)) {
            if ((visit & (1 << next)) == 0) { // 방문하지 않은 노드라면
                visit |= (1 << next);
                dfs(next, mul);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a, b, p, q, tmp1, tmp2, div;
        n = Integer.parseInt(br.readLine());
        amounts = new int[n];
        graph = new ArrayList<>(n);

        // 초기화
        for (int i = 0; i < n; i++) {
            amounts[i] = 1; // 초기값 설정
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            p = Integer.parseInt(st.nextToken());
            q = Integer.parseInt(st.nextToken());

            // 현재 값들을 비율에 맞게 계산
            tmp1 = amounts[b] * p;
            tmp2 = amounts[a] * q;
            div = gcd(tmp1, tmp2);
            visit = 0; // 방문 초기화

            // DFS 실행하여 비율 적용
            dfs(a, tmp1 / div);
            dfs(b, tmp2 / div);

            // 양방향 그래프 저장
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for (int i = 0; i < n; i++) {
            System.out.print(amounts[i] + " ");
        }
    }
}
