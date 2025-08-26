import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int J = Integer.parseInt(br.readLine());

        int[] apple = new int[J];

        int left = 1;
        int right = M;
        int totalMove = 0;

        for (int i=0; i<J; i++) {
            int pos = Integer.parseInt(br.readLine());
            
            if (left <= pos && pos <= right) {
                continue;
            } else if (pos < left) {
                int move = left - pos;
                totalMove += move;
                left = pos;
                right = pos + M - 1;
            } else if (pos > right) {
                int move = pos - right;
                totalMove += move;
                right = pos;
                left = pos - M + 1;
            }
        }
        System.out.println(totalMove);
    }
}