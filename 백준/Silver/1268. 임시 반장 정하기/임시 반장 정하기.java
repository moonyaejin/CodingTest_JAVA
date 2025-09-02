import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[][] student = new int[N][5];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int k = 0; k < 5; k++) {
                student[i][k] = Integer.parseInt(st.nextToken());
            }
        }

        int[] count = new int[N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j) continue;
                for (int k = 0; k < 5; k++) {
                    if (student[i][k] == student[j][k]) {
                        count[i]++;
                        break;
                    }
                }
            }
        }

        int maxCount = -1;
        int leader = 0;
        for (int i = 0; i < N; i++) {
            if (count[i] > maxCount) {
                maxCount = count[i];
                leader = i;
            }
        }

        System.out.println(leader + 1);
    }
}
