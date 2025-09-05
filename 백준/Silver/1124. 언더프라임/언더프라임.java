import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int underPrime = 0;
        
        for (int i = A; i <= B; i++) {
            if (isUnderPrime(i)) {
                underPrime++;
            }
        }
        System.out.println(underPrime);
    }
    static boolean isUnderPrime(int x) {
        int count = 0;

        int num = x;
        for (int i = 2; i * i <= num; i++) {
            while (num % i == 0) {
                count++;
                num /= i;
            }
        }
        if (num > 1) count++;

        if (count < 2) return false;
        for (int i = 2; i * i <= count; i++) {
            if (count % i == 0) return false;
        }
        return true;
    }
}