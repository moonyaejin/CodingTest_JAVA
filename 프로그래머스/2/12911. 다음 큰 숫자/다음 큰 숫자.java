class Solution {
    public int solution(int n) {
        int bigNum = 0;
        
        String binary = Integer.toBinaryString(n);
        int countOne = binary.length() - binary.replace("1", "").length();
        
         for (int i = n + 1; ; i++) {
                String binaryNumBig = Integer.toBinaryString(i);
                int countOneBig = binaryNumBig.length() - binaryNumBig.replace("1", "").length();
                
                if (countOne == countOneBig) {
                    bigNum = i;
                    break;
                }
            }
        
        return bigNum;
    }
}