class Solution {
    public int solution(int n) {
        int count = 0;
        
        for (int start = 1; start <= n; start++) {
            int sum = 0;
            
            for (int j = start; j <= n; j++) {
                sum += j;
                if (sum == n) {
                    count++;
                    break;
                } else if (sum > n) break;
            }
        }
        return count;
    }
}