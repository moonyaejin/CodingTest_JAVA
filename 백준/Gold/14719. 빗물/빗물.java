import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // H와 W 입력 받기
        int H = sc.nextInt();
        int W = sc.nextInt();

        // 블록 높이 배열 입력 받기
        int[] heights = new int[W];
        for (int i = 0; i < W; i++) {
            heights[i] = sc.nextInt();
        }

        // 왼쪽과 오른쪽에서 가장 높은 블록 저장할 배열
        int[] leftMax = new int[W];
        int[] rightMax = new int[W];

        // 왼쪽에서 가장 높은 블록 계산
        leftMax[0] = heights[0];
        for (int i = 1; i < W; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], heights[i]);
        }

        // 오른쪽에서 가장 높은 블록 계산
        rightMax[W - 1] = heights[W - 1];
        for (int i = W - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], heights[i]);
        }

        // 빗물 계산
        int totalWater = 0;
        for (int i = 0; i < W; i++) {
            int water = Math.min(leftMax[i], rightMax[i]) - heights[i];
            if (water > 0) {
                totalWater += water;
            }
        }

        // 결과 출력
        System.out.println(totalWater);
    }
}
