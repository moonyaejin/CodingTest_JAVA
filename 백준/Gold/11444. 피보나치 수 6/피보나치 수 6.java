import java.io.*;
import java.util.*;

public class Main {
    static final long MOD = 1_000_000_007L;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        System.out.println(fib(n));
    }

    // n번째 피보나치 수를 구함
    static long fib(long n) {
        if (n == 0) return 0;
        long[][] result = pow(new long[][]{{1,1},{1,0}}, n-1);
        return result[0][0];
    }

    // 2x2 행렬의 거듭제곱
    static long[][] pow(long[][] m, long exp) {
        long[][] result = {{1,0},{0,1}}; // 단위행렬
        while (exp > 0) {
            if ((exp & 1) == 1) result = mul(result, m);
            m = mul(m, m);
            exp >>= 1;
        }
        return result;
    }

    // 2x2 행렬 곱셈
    static long[][] mul(long[][] a, long[][] b) {
        long[][] c = new long[2][2];
        for (int i=0; i<2; i++)
            for (int j=0; j<2; j++)
                for (int k=0; k<2; k++)
                    c[i][j] = (c[i][j] + a[i][k]*b[k][j]%MOD) % MOD;
        return c;
    }
}
