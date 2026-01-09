import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        Set<String> used = new HashSet<>();
        used.add(words[0]);
        
        for (int i = 1; i < words.length; i++) {
            String prev = words[i - 1];
            String curr = words[i];
            
            // 탈락 조건: 이미 사용한 단어 OR 끝말잇기 규칙 위반
            if (used.contains(curr) || prev.charAt(prev.length() - 1) != curr.charAt(0)) {
                int person = (i % n) + 1;  // 몇 번 사람
                int turn = (i / n) + 1;    // 몇 번째 차례
                return new int[]{person, turn};
            }
            
            used.add(curr);
        }
        
        return new int[]{0, 0};
    }
}