import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // 테스트 케이스 개수
        int[] testCases = new int[T];
        
        for (int i = 0; i < T; i++) {
            testCases[i] = sc.nextInt(); // 각 테스트 케이스 입력
        }
        
        sc.close();
        
        // 0과 1의 호출 횟수를 저장할 DP 배열
        int[][] dp = new int[41][2];
        
        // 초기 값 설정
        dp[0][0] = 1; dp[0][1] = 0;
        dp[1][0] = 0; dp[1][1] = 1;
        
        // DP 테이블 채우기
        for (int i = 2; i <= 40; i++) {
            dp[i][0] = dp[i - 1][0] + dp[i - 2][0];
            dp[i][1] = dp[i - 1][1] + dp[i - 2][1];
        }
        
        // 테스트 케이스 결과 출력
        for (int N : testCases) {
            System.out.println(dp[N][0] + " " + dp[N][1]);
        }
    }
}