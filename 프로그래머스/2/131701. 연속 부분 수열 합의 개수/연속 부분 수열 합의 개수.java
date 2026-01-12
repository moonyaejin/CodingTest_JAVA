import java.util.*;

class Solution {
    public int solution(int[] elements) {
        HashSet<Integer> sums = new HashSet<>();
        
        for (int start = 0; start < elements.length; start++) {
            for (int length = 1; length <= elements.length; length++) {
                int sum = 0;
                for (int i = 0; i < length; i++) {
                    int idx = (start + i) % elements.length;
                    sum += elements[idx];
                }
                sums.add(sum);
            }
        }
        return sums.size();
    }
}