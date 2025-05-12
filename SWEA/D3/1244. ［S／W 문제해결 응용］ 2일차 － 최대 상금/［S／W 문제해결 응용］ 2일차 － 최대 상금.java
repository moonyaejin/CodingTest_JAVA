import java.util.*;

class Solution {
    static int max;
    static int swapCount;
    static char[] number;
    static HashSet<String>[] visited; // depth별 visited set

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // 테스트 케이스 수

        for (int test_case = 1; test_case <= T; test_case++) {
            number = sc.next().toCharArray();     // 숫자판
            swapCount = sc.nextInt();             // 교환 횟수
            max = 0;

            // 방문 기록 초기화 (0~10 depth)
            visited = new HashSet[swapCount + 1];
            for (int i = 0; i <= swapCount; i++) {
                visited[i] = new HashSet<>();
            }

            dfs(0); // 깊이 0부터 시작

            System.out.println("#" + test_case + " " + max);
        }
    }

    static void dfs(int depth) {
        String current = String.valueOf(number);

        // 이미 방문한 상태이면 종료
        if (visited[depth].contains(current)) return;
        visited[depth].add(current);

        // 교환 횟수 다 쓰면 결과 확인
        if (depth == swapCount) {
            int currentValue = Integer.parseInt(current);
            max = Math.max(max, currentValue);
            return;
        }

        // 모든 자리쌍에 대해 교환
        for (int i = 0; i < number.length - 1; i++) {
            for (int j = i + 1; j < number.length; j++) {
                swap(i, j);
                dfs(depth + 1);   // 다음 깊이로 탐색
                swap(i, j);       // 원상복구
            }
        }
    }

    static void swap(int i, int j) {
        char temp = number[i];
        number[i] = number[j];
        number[j] = temp;
    }
}
