import java.util.Scanner;

class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); 

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt(); 
            int M = sc.nextInt(); 

            int[][] map = new int[N][N];

            // 격자 입력
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    map[i][j] = sc.nextInt();
                }
            }

            int max = 0;

            // M×M 이동하며 최대 파리 수 계산
            for (int i = 0; i <= N - M; i++) {
                for (int j = 0; j <= N - M; j++) {
                    int sum = 0;
                    for (int x = 0; x < M; x++) {
                        for (int y = 0; y < M; y++) {
                            sum += map[i + x][j + y];
                        }
                    }
                    if (sum > max) {
                        max = sum;
                    }
                }
            }

            System.out.println("#" + test_case + " " + max);
        }
    }
}