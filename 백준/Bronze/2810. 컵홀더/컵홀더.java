import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String seats = br.readLine();

        int count = 0;
        for (int i = 0; i < seats.length(); i++) {
            if (seats.charAt(i) == 'L') count++;
        }

        int couples = count / 2;
        int cupHolder = N - couples + 1;

        int answer = Math.min(N, cupHolder);
        System.out.println(answer);
    }
}
