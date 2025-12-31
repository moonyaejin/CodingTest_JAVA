class Solution {
    public int[] solution(String s) {
        int c = 0;
        int transformCount = 0;
        int removedZeros = 0;
        
        while(!s.equals("1")) {
            int zeros = s.length() - s.replace("0", "").length();
            removedZeros += zeros;
            
            s = s.replace("0", "");
            c = s.length();
            
            s = Integer.toBinaryString(c);
            
            transformCount++;
        }
        
        return new int[] {transformCount, removedZeros};
    }
}