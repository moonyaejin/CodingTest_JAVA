import java.util.Scanner;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long a = sc.nextLong(); 
        long b = sc.nextLong();

        long g = gcd(a, b);  
        
        StringBuilder sb = new StringBuilder();
        for (long i = 0; i < g; i++) {
            sb.append('1');
        }

        System.out.println(sb.toString());
    }

    // 유클리드 호제법
    private static long gcd(long a, long b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
