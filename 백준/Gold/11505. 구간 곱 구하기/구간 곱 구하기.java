import java.io.*;
import java.util.*;

public class Main {
    // 모듈러 연산 상수 (오버플로우 방지 + 문제 조건)
    static final int MOD = 1_000_000_007;
    static long[] arr;
    static long[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 1. N: 수의 개수, M: 변경 연산 수, K: 구간 곱 쿼리 수
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // 2. 수 배열 입력 받기 (1-based 입력 → 0-based 배열)
        arr = new long[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        // 3. 세그먼트 트리 배열 초기화 (최대 4N 크기)
        tree = new long[N * 4];
        init(0, N - 1, 1); // 전체 범위 [0, N-1]을 루트 노드 1부터 시작

        // 4. M + K번의 연산 처리
        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); // 연산 타입 (1: 수 변경, 2: 구간 곱)
            int b = Integer.parseInt(st.nextToken()); 
            int c = Integer.parseInt(st.nextToken()); 

            if (a == 1) {
                // 값 변경 연산: b번째 수를 c로 변경 (1-based → 0-based)
                update(0, N - 1, 1, b - 1, c);
            } else if (a == 2) {
                // 구간 곱 쿼리: [b, c] (1-based → 0-based)
                long result = query(0, N - 1, 1, b - 1, c - 1);
                System.out.println(result);
            }
        }
    }

    static long init(int start, int end, int node) {
        if (start == end) {
            return tree[node] = arr[start];
        }

        // 중간 인덱스 계산
        int mid = (start + end) / 2;

        // 좌측, 우측 자식 노드 재귀적으로 초기화하고 곱 저장
        long left = init(start, mid, node * 2);
        long right = init(mid + 1, end, node * 2 + 1);

        // 현재 노드는 좌우 자식의 곱을 모듈러로 저장
        return tree[node] = (left * right) % MOD;
    }

    static long update(int start, int end, int node, int index, long value) {
        // 현재 노드 범위 밖이면 그대로 반환
        if (index < start || index > end) return tree[node];

        // 리프 노드에 도달 → 값 변경
        if (start == end) {
            return tree[node] = value;
        }

        int mid = (start + end) / 2;

        // 좌우 자식 노드로 재귀 호출 후, 곱을 다시 계산
        long left = update(start, mid, node * 2, index, value);
        long right = update(mid + 1, end, node * 2 + 1, index, value);

        return tree[node] = (left * right) % MOD;
    }

    /**
     * 세그먼트 트리에서 구간 곱 쿼리를 처리하는 함수
     * [left, right] 범위의 곱을 반환
     */
    static long query(int start, int end, int node, int left, int right) {
        // 구간 밖이면 곱셈 항등원 1 반환
        if (right < start || end < left) return 1;

        // 구간 완전히 포함되면 트리 노드 값 반환
        if (left <= start && end <= right) return tree[node];

        int mid = (start + end) / 2;

        // 왼쪽과 오른쪽 자식에서 구간 곱 구하고, 그 곱을 반환
        long l = query(start, mid, node * 2, left, right);
        long r = query(mid + 1, end, node * 2 + 1, left, right);

        return (l * r) % MOD;
    }
}
