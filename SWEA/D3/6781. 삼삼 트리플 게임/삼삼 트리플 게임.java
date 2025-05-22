import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();  // 테스트 케이스 개수

        for (int t = 1; t <= T; t++) {
            String numberStr = sc.next();  // 숫자 입력
            String colorStr = sc.next();   // 색깔 입력

            // 색깔별 숫자 개수 카운트 배열 (1~9니까 인덱스 1~9 사용)
            int[][] colorCount = new int[3][10]; // 0: R, 1: G, 2: B

            for (int i = 0; i < 9; i++) {
                int num = numberStr.charAt(i) - '0';
                char color = colorStr.charAt(i);
                int colorIndex = getColorIndex(color);
                colorCount[colorIndex][num]++;
            }

            int totalSets = 0;

            for (int c = 0; c < 3; c++) { // 각 색상별로
                int[] count = colorCount[c];
                totalSets += countSets(count);
            }

            System.out.print("#" + t + " ");
            System.out.println(totalSets >= 3 ? "Win" : "Continue");
        }

        sc.close();
    }

    // 색을 인덱스로 매핑
    private static int getColorIndex(char color) {
        if (color == 'R') return 0;
        else if (color == 'G') return 1;
        else return 2; // 'B'
    }

    // 세트 개수를 세는 함수
    private static int countSets(int[] count) {
        int sets = 0;

        // 1. 같은 숫자 3개 (Triplet)
        for (int i = 1; i <= 9; i++) {
            while (count[i] >= 3) {
                count[i] -= 3;
                sets++;
            }
        }

        // 2. 연속된 숫자 3개 (Run)
        for (int i = 1; i <= 7; i++) {
            while (count[i] >= 1 && count[i + 1] >= 1 && count[i + 2] >= 1) {
                count[i]--;
                count[i + 1]--;
                count[i + 2]--;
                sets++;
            }
        }

        return sets;
    }
}
