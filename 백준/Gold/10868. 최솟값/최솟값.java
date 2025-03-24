import java.io.*;
import java.util.*;

public class Main {
    
    static int N, M;            // N: 배열 크기, M: 쿼리 개수
    static int[] arr;           // 입력 배열 (1번 인덱스부터 사용)
    static int[] tree;          // 세그먼트 트리 배열
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // 1. N과 M 입력 받기
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        // 2. 입력 배열 초기화 및 값 입력 받기
        arr = new int[N + 1]; // 1-based index 사용
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        // 3. 세그먼트 트리 배열 크기 초기화 및 구성
        tree = new int[4 * N]; // 세그먼트 트리 배열은 넉넉하게 4배 크기로 선언
        build(1, 1, N);        // 루트 노드부터 트리 구성 시작 (node=1, 범위=1~N)
        
        // 4. M개의 쿼리 처리
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken());   // 쿼리 시작 위치
            int right = Integer.parseInt(st.nextToken());  // 쿼리 끝 위치
            
            // 5. 구간 최소값 쿼리 실행 및 결과 저장
            int minValue = query(1, 1, N, left, right); // 루트부터 탐색
            sb.append(minValue).append("\n");
        }

        // 6. 결과 한 번에 출력
        System.out.print(sb);
    }
    
    // 세그먼트 트리 구성 함수
    // node: 현재 노드 번호
    // start, end: 현재 노드가 담당하는 구간 [start, end]
    static void build(int node, int start, int end) {
        // 리프 노드인 경우, 원본 배열의 값을 그대로 저장
        if (start == end) {
            tree[node] = arr[start];
        } else {
            int mid = (start + end) / 2;
            // 왼쪽 자식 트리 구성
            build(node * 2, start, mid);
            // 오른쪽 자식 트리 구성
            build(node * 2 + 1, mid + 1, end);
            // 현재 노드에 왼쪽/오른쪽 자식 중 최솟값 저장
            tree[node] = Math.min(tree[node * 2], tree[node * 2 + 1]);
        }
    }
    
    // 구간 최소값을 찾는 함수
    // node: 현재 노드 번호
    // start, end: 현재 노드가 담당하는 구간 [start, end]
    // left, right: 찾고자 하는 구간 [left, right]
    static int query(int node, int start, int end, int left, int right) {
        // case 1: 현재 노드의 구간이 [left, right]와 겹치지 않으면 무시
        if (right < start || end < left) {
            return Integer.MAX_VALUE; // 최소값을 찾는 것이므로 최대값 반환
        }
        
        // case 2: 현재 노드의 구간이 [left, right]에 완전히 포함되면 현재 노드 값 사용
        if (left <= start && end <= right) {
            return tree[node];
        }
        
        // case 3: 일부만 겹치는 경우, 양쪽 자식 노드 탐색
        int mid = (start + end) / 2;
        int lMin = query(node * 2, start, mid, left, right);       // 왼쪽 자식
        int rMin = query(node * 2 + 1, mid + 1, end, left, right); // 오른쪽 자식
        return Math.min(lMin, rMin); // 두 구간 중 최솟값 반환
    }
}
