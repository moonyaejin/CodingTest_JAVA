import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1. 입력 받기
        int N = Integer.parseInt(br.readLine());
        int[] buildings = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            buildings[i] = Integer.parseInt(st.nextToken());
        }

        int maxVisible = 0; // 최대로 보이는 빌딩 개수

        // 2. 각 빌딩에서 보이는 빌딩 개수 계산
        for (int i = 0; i < N; i++) {
            int visibleCount = 0;

            // 왼쪽 탐색 (기울기 최소값 유지)
            double leftSlope = Double.MAX_VALUE;
            for (int j = i - 1; j >= 0; j--) {
                double slope = (double) (buildings[i] - buildings[j]) / (i - j);
                if (slope < leftSlope) { // 기울기가 더 작아야 보인다.
                    leftSlope = slope;
                    visibleCount++;
                }
            }

            // 오른쪽 탐색 (기울기 최대값 유지)
            double rightSlope = -Double.MAX_VALUE;
            for (int j = i + 1; j < N; j++) {
                double slope = (double) (buildings[j] - buildings[i]) / (j - i);
                if (slope > rightSlope) { // 기울기가 더 커야 보인다.
                    rightSlope = slope;
                    visibleCount++;
                }
            }

            // 3. 최대값 갱신
            maxVisible = Math.max(maxVisible, visibleCount);
        }

        // 4. 결과 출력
        System.out.println(maxVisible);
    }
}
