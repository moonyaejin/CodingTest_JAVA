import java.util.Scanner;
import java.util.Scanner;

class Solution {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); 

        for (int test_case = 1; test_case <= T; test_case++) {
            int testCaseNum = sc.nextInt(); 

            int[] freq = new int[101]; 

            // 점수 1000개
            for (int i = 0; i < 1000; i++) {
                int score = sc.nextInt();
                freq[score]++;
            }

            // 최빈값 찾기
            int mode = 0;
            for (int i = 1; i <= 100; i++) {
                if (freq[i] > freq[mode] || (freq[i] == freq[mode] && i > mode)) {
                    mode = i;
                }
            }

            // 결과 출력
            System.out.println("#" + testCaseNum + " " + mode);
        }
    }
}
