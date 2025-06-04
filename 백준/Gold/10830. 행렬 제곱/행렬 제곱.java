import java.util.Scanner;

public class Main {
    static int N;
    static long B;
    static final int MOD = 1000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        B = sc.nextLong();

        int[][] A = new int[N][N];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                A[i][j] = sc.nextInt() % MOD; // 입력과 동시에 mod 1000 처리

        int[][] result = power(A, B);

        for (int[] row : result) {
            for (int value : row)
                System.out.print(value + " ");
            System.out.println();
        }
    }

    public static int[][] power(int[][] A, long exp) {
        if (exp == 1)
            return A;

        int[][] half = power(A, exp / 2);
        int[][] halfSquared = multiply(half, half);

        if (exp % 2 == 0)
            return halfSquared;
        else
            return multiply(halfSquared, A);
    }

    public static int[][] multiply(int[][] A, int[][] B) {
        int[][] result = new int[N][N];

        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++) {
                int sum = 0;
                for (int k = 0; k < N; k++)
                    sum = (sum + A[i][k] * B[k][j]) % MOD;
                result[i][j] = sum;
            }

        return result;
    }
}
