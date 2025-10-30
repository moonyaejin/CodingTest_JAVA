import java.util.*;

class Solution {
    static List<int[]> result = new ArrayList<>();
    
    public int[][] solution(int n) {
        hanoi(n, 1, 3, 2);
        return result.toArray(new int[result.size()][]);
    }
    
    // 재귀 함수: n개의 원판을 from에서 to로 옮김
    private void hanoi(int n, int from, int to, int aux) {
        if (n == 1) {
            // 원판 1개면 바로 이동
            result.add(new int[]{from, to});
            return;
        }
        // n-1개의 원판을 보조 기둥으로 이동
        hanoi(n - 1, from, aux, to);
        // 가장 큰 원판을 목적지로 이동
        result.add(new int[]{from, to});
        // n-1개의 원판을 목적지로 이동
        hanoi(n - 1, aux, to, from);
    }
}