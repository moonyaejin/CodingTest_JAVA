import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        while (true) {
            if (isPalindrome(n) && isPrime(n)) {
                System.out.println(n);
                break;
            }
            n++;
        }
    }

    public static boolean isPalindrome(int num) {
        String str = Integer.toString(num);
        String reversed = new StringBuilder(str).reverse().toString();
        return str.equals(reversed);
    }

    public static boolean isPrime(int num) {
        if (num < 2) return false;
        int sqrt = (int)Math.sqrt(num);
        for (int i = 2; i <= sqrt; i++) { 
            if (num % i == 0) return false;
        }
        return true;
    }
}
