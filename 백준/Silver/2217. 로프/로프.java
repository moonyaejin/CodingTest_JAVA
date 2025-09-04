import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] w = new int[N];
        
        for (int i = 0; i < N; i++) {
            w[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(w);

        int max = 0;
        int answer = 0;
        
        for (int i = 0; i < N; i++) {
            answer = w[i] * (N - i);
            if (answer > max) max = answer;
        }

        System.out.println(max);
    }
}