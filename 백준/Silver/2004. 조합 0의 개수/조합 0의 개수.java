import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        int count2 = countFactor(n, 2) - countFactor(m, 2) - countFactor(n - m, 2);
        int count5 = countFactor(n, 5) - countFactor(m, 5) - countFactor(n - m, 5);

        System.out.println(Math.min(count2, count5));
    }

    static int countFactor(int num, int factor) {
        int count = 0;
        while (num > 0) {
            count += num / factor;
            num /= factor;
        }
        return count;
    }
}
