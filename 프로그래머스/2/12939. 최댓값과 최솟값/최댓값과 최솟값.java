class Solution {
    public String solution(String s) {
        String nums[] = s.split(" ");
        
        int max = Integer.parseInt(nums[0]);
        int min = Integer.parseInt(nums[0]);
        
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max, Integer.parseInt(nums[i]));
            min = Math.min(min, Integer.parseInt(nums[i]));
        }
        
        return min + " " + max;
    }
}