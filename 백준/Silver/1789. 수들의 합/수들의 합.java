import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long S = Long.parseLong(br.readLine());

        long sum = 0;
        int count = 0;

        // 무한 루프 돌다가 sum > S면 멈춤
        for (int i = 1; ; i++) {
            sum += i;
            if (sum > S) break;
            count++;
        }

        System.out.println(count);
    }
}
