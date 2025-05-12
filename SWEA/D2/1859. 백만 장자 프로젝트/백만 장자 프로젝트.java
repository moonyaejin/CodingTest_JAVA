import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        // 빠른 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트케이스 개수

        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine()); // 날짜 수
            int[] prices = new int[N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                prices[i] = Integer.parseInt(st.nextToken());
            }

            // 뒤에서부터 탐색
            long profit = 0;
            int maxPrice = 0;

            for (int i = N - 1; i >= 0; i--) {
                if (prices[i] > maxPrice) {
                    maxPrice = prices[i];
                } else {
                    profit += maxPrice - prices[i];
                }
            }

            System.out.println("#" + t + " " + profit);
        }
    }
}
