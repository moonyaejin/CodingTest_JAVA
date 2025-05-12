import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());  // 총 인원 수
        int k = Integer.parseInt(st.nextToken());  // K번째 제거됨

        int result = 0;

        for (int i = 2; i <= n; i++) {
            result = (result + k) % i;
        }

        System.out.println(result + 1);
    }
}