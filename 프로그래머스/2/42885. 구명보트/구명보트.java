import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        
        int left = 0;
        int right = people.length - 1;
        int boats = 0;
        
        while(left <= right) {
            // 둘 다 태울 수 있으면
            if (people[left] + people[right] <= limit) {
                left++;
                right--;
            }
            // 무거운 사람만 태울 수 있으면
            else {
                right--;
            }
            //보트 하나 사용
            boats++;
        }
        
        return boats;
    }
}