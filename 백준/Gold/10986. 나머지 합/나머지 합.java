import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        long[] A = new long[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextLong();
        }

        long[] modCount = new long[M];
        long sum = 0;
        long result = 0;

        modCount[0] = 1;

        for (int i = 0; i < N; i++) {
            sum += A[i];
            int mod = (int)(sum % M);
            result += modCount[mod];
            modCount[mod]++;
        }

        System.out.println(result);
    }
}