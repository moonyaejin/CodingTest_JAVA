import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[][] scores = new int[N][2];

            for (int j = 0; j < N; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                scores[j][0] = Integer.parseInt(st.nextToken()); // 서류
                scores[j][1] = Integer.parseInt(st.nextToken()); // 면접
            }
            
            Arrays.sort(scores, (a, b) -> a[0] - b[0]); // 서류 기준 정렬
            int count = 1;
            int minInterview = scores[0][1];

            for (int j = 1; j < N; j++) {
                if (scores[j][1] < minInterview) {
                    count++;
                    minInterview = scores[j][1];
                }
            }
            System.out.println(count);
        }
    }
}