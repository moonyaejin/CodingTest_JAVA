import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); 
        int P[] = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            P[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(P);  // 인출 시간이 짧으려면 오름차순 정렬

        int total = 0;
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += P[i];
            total += sum;
        }

        System.out.println(total);
    }
}