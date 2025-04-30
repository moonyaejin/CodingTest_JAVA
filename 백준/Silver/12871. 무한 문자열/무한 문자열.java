import java.util.*;
import java.io.*;

public class Main {
    // 최대공약수
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    // 최소공배수
    public static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        String t = br.readLine();

        int len_s = s.length();
        int len_t = t.length();
        int l = lcm(len_s, len_t);

        // 반복 문자열 저장 공간
        StringBuilder fs = new StringBuilder();
        StringBuilder ft = new StringBuilder();

        for (int i = 0; i < l / len_s; i++) fs.append(s);
        for (int i = 0; i < l / len_t; i++) ft.append(t);

        System.out.println(fs.toString().equals(ft.toString()) ? 1 : 0);
    }
}
