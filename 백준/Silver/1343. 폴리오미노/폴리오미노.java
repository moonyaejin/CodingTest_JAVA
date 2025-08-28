import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String board = br.readLine();
        StringBuilder sb = new StringBuilder();
        
        int count = 0;

        for (int i = 0; i < board.length(); i++) {
            char ch = board.charAt(i);
            
            if (ch == 'X') count++;
            else {
                if (count > 0) {
                    // 홀수면
                    if (count % 2 != 0) {
                        System.out.println(-1);
                        return;
                    }
                    sb.append("AAAA".repeat(count / 4));
                    if (count % 4 == 2) sb.append("BB");
                    count = 0;
                }
                sb.append('.');
            }
        }

        // 마지막 구간 처리
        if (count > 0) {
            if (count % 2 != 0) {
                System.out.println(-1);
                return;
            }
            sb.append("AAAA".repeat(count / 4));
            if (count % 4 == 2) sb.append("BB");
        }

        System.out.println(sb.toString());
    }
}
