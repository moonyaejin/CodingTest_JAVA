import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();

        while (true) {
            String line = br.readLine();
            if (line == null) break;

            StringTokenizer st = new StringTokenizer(line);
            int N = Integer.parseInt(st.nextToken());
            if (N == 0) break;

            StringBuilder one = new StringBuilder();
            int prev = -1;

            for (int i = 0; i < N; i++) {
                int x = Integer.parseInt(st.nextToken());
                if (i == 0 || x != prev) one.append(x).append(' ');
                prev = x;
            }
            one.append('$');
            out.append(one).append('\n');
        }

        System.out.print(out);
    }
}
