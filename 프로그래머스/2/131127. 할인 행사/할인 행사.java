import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        Map<String, Integer> need = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            need.put(want[i], number[i]);
        }

        Map<String, Integer> window = new HashMap<>();
        // 초기 10일 윈도우
        for (int i = 0; i < 10 && i < discount.length; i++) {
            window.put(discount[i], window.getOrDefault(discount[i], 0) + 1);
        }

        int answer = 0;

        for (int i = 0; i <= discount.length - 10; i++) {

            if (i > 0) {
                // 왼쪽 제거
                String prev = discount[i - 1];
                window.put(prev, window.get(prev) - 1);

                // 오른쪽 추가
                String next = discount[i + 9];
                window.put(next, window.getOrDefault(next, 0) + 1);
            }

            // 조건 체크
            if (isValid(need, window)) {
                answer++;
            }
        }

        return answer;
    }

    private boolean isValid(Map<String, Integer> need, Map<String, Integer> window) {
        for (String item : need.keySet()) {
            if (window.getOrDefault(item, 0) < need.get(item)) {
                return false;
            }
        }
        return true;
    }
}
