import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] ab = br.readLine().split(" ");
        String A = ab[0], B = ab[1];
        int N = A.length(), M = B.length();

        // 교차점 찾기: A의 왼쪽부터, B에서의 첫 등장 사용
        int col = 0, row = 0;
        for (int i = 0; i < N; i++) {
            int j = B.indexOf(A.charAt(i));
            if (j != -1) { col = i; row = j; break; }
        }

        StringBuilder sb = new StringBuilder();
        for (int r = 0; r < M; r++) {
            if (r == row) {
                sb.append(A);
            } else {
                for (int k = 0; k < col; k++) sb.append('.');
                sb.append(B.charAt(r));
                for (int k = col + 1; k < N; k++) sb.append('.');
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}
