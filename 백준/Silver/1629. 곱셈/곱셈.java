import java.util.*;
import java.io.*;

public class Main {
    public static long pow(long a, long b, long c) {
        if (b == 0) return 1;
        long half = pow(a, b / 2, c);
        long result = (half * half) % c;

        // 지수가 홀수라면 half**2 * a가 필요
        if (b % 2 == 1) {
            result = (result * a) % c;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long A = sc.nextLong();
        long B = sc.nextLong();
        long C = sc.nextLong();

        System.out.println(pow(A, B, C));
    }
}