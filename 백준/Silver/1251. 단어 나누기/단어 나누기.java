import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        int n = s.length();

        String minWord = null;

        for (int i = 1; i <= n - 2; i++ ) {
            for (int j = i + 1; j <= n - 1; j++) {

                // 세 구간 나누기
                String A = s.substring(0, i);
                String B = s.substring(i, j);
                String C = s.substring(j);

                // 뒤집기
                String revA = new StringBuilder(A).reverse().toString();
                String revB = new StringBuilder(B).reverse().toString();
                String revC = new StringBuilder(C).reverse().toString();

                String newWord = revA + revB + revC;

                // 사전순 최소 갱신
                if (minWord == null || newWord.compareTo(minWord) < 0) {
                    minWord = newWord;
                }
            }
        }

        System.out.println(minWord);
    }
}