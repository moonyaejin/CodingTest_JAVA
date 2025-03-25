import java.io.*;
import java.util.*;

public class Main {

    static int N, M, K;
    static long[] arr;      // 원본 배열
    static long[] tree;     // 세그먼트 트리

    public static void main(String[] args) throws IOException {
        // 빠른 입출력을 위한 BufferedReader / BufferedWriter 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // N: 수의 개수, M: 업데이트 횟수, K: 구간 합 횟수
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new long[N];
        tree = new long[4 * N];  // 세그먼트 트리는 보통 4배 크기로 잡음

        // 원본 배열 입력
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        // 세그먼트 트리 초기화
        init(1, 0, N - 1);

        // 쿼리 처리
        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken()); // 명령어: 1 or 2
            int b = Integer.parseInt(st.nextToken()); // 인덱스 또는 시작 구간
            long c = Long.parseLong(st.nextToken());  // 값 또는 끝 구간

            if (a == 1) {
                // 값 변경: b번째 수를 c로 바꿈
                int idx = b - 1;
                long diff = c - arr[idx];  // 변경값 차이
                arr[idx] = c;  // 실제 배열 값 변경
                update(1, 0, N - 1, idx, diff);  // 트리 업데이트
            } else if (a == 2) {
                // 구간 합 출력
                int left = b - 1;
                int right = (int) c - 1;
                long sumResult = sum(1, 0, N - 1, left, right);
                bw.write(sumResult + "\n");
            }
        }

        // 출력 flush
        bw.flush();
        bw.close();
        br.close();
    }

    // 세그먼트 트리 초기화 함수
    static long init(int node, int start, int end) {
        if (start == end) {
            return tree[node] = arr[start];
        }
        int mid = (start + end) / 2;
        return tree[node] = init(node * 2, start, mid) + init(node * 2 + 1, mid + 1, end);
    }

    // 값 업데이트 함수
    static void update(int node, int start, int end, int idx, long diff) {
        // idx가 이 구간에 속하지 않으면 return
        if (idx < start || idx > end) return;

        // 현재 노드에 변경값 반영
        tree[node] += diff;

        // 리프 노드가 아니면 자식도 업데이트
        if (start != end) {
            int mid = (start + end) / 2;
            update(node * 2, start, mid, idx, diff);
            update(node * 2 + 1, mid + 1, end, idx, diff);
        }
    }

    // 구간 합을 구하는 함수
    static long sum(int node, int start, int end, int left, int right) {
        // [start, end]가 [left, right]와 겹치지 않음
        if (right < start || end < left) return 0;

        // [start, end]가 [left, right]에 완전히 포함됨
        if (left <= start && end <= right) return tree[node];

        // 일부만 겹침 → 자식 노드로 분할
        int mid = (start + end) / 2;
        return sum(node * 2, start, mid, left, right)
             + sum(node * 2 + 1, mid + 1, end, left, right);
    }
}
