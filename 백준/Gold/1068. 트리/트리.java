import java.util.*;
import java.io.*;

public class Main {
    // 각 노드의 자식 노드들을 저장할 인접리스트 (children[i]는 i의 자식 리스트)
    static ArrayList<Integer>[] children;
    // 삭제할 노드 번호
    static int deleteNode;
    // 남은 트리의 리프 노드 개수
    static int leafCount = 0;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        // children 배열 초기화
        children = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            children[i] = new ArrayList<>();
        }

        // parent[i]가 -1이면 그 노드가 루트
        StringTokenizer st = new StringTokenizer(br.readLine());
        int root = -1;   // 루트 노드 인덱스 저장용, 없으면 -1
        for (int i = 0; i < N; i++) {
            int parent = Integer.parseInt(st.nextToken());
            if (parent == -1) {
                // 부모가 없으면 이 노드가 루트
                root = i;
            } else {
                // 부모가 있으면 부모의 자식 리스트에 이 노드를 추가
                children[parent].add(i);
            }
        }

        // 지울 노드 번호
        deleteNode = Integer.parseInt(br.readLine());

        // 만약 루트를 지우면 트리가 완전히 사라지므로 리프 개수는 0
        if (root == deleteNode) {
            System.out.println(0);
            return;
        }

        dfs(root);

        System.out.println(leafCount);
    }

    /**
     * DFS로 트리를 순회하면서 리프 노드 개수를 센다.
     * - 현재 노드가 삭제 대상이면(이미 제거된 서브트리) 즉시 리턴한다.
     * - "리프" 판정 기준: (삭제된 노드를 제외한) 유효한 자식이 하나도 없으면 리프이다.
     *
     * @param node 현재 방문 노드
     */

    static void dfs(int node) {
        // 현재 노드가 삭제 대상이면 이 노드와 자식은 실제 트리에 없으므로 탐색 중단
        if (node == deleteNode) return;

        // 이 노드의 유효한 자식의 개수를 센다
        int validChild = 0;
        for (int child : children[node]) {
            // 자식이 삭제 대상이면 무시
            if (child == deleteNode) continue;

            // 삭제되지 않은 자식이 하나라도 있으면 카운트하고 재귀
            validChild++;
            dfs(child);
        }

        // 만약 유효한 자식이 하나도 없다면 이 노드는 리프
        if (validChild == 0) {
            leafCount++;
        }
    }
}