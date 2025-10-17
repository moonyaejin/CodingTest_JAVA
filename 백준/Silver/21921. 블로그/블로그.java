import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 전체 일수
        int X = Integer.parseInt(st.nextToken()); // 연속 일수

        int[] visits = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            visits[i] = Integer.parseInt(st.nextToken());
        }

        // 초기 윈도우(첫 X일)의 방문자 합 계산
        long windowSum = 0;
        for (int i = 0; i < X; i++) {
            windowSum += visits[i];
        }

        long maxSum = windowSum; // 최대 방문자 수
        int count = 1; // 해당 최대 방문자 수를 가진 구간 수

        // 슬라이딩 윈도우: X일부터 N일까지 반복
        for (int i = X; i < N; i++) {
            // 윈도우를 한 칸 오른쪽으로 이동
            windowSum += visits[i] - visits[i - X];

            if (windowSum > maxSum) {
                maxSum = windowSum;
                count = 1; // 새로운 최대값이므로 카운트 초기화
            } else if (windowSum == maxSum) {
                count++; // 같은 최대값을 가진 구간 발견
            }
        }

        if (maxSum == 0) {
            System.out.println("SAD");
        } else {
            System.out.println(maxSum);
            System.out.println(count);
        }
    }
}
