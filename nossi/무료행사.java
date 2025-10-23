class Solution {
    public int solution(int[] prices, int target) {
        int count = 0;
        int length = prices.length;
        
        for(int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (prices[i] + prices[j] == target) {
                    count++;
                }
            }
        }
        return count;
    }
}
