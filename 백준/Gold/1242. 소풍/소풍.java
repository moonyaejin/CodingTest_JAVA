import java.util.*;
import java.io.*;
 

public class Main {
    static int n;
    static int k;
    static int m;

    static void input() {
        Reader scanner = new Reader();

        n = scanner.nextInt();
        k = scanner.nextInt();
        m = scanner.nextInt();
    }

    static void solution() {
        int answer = 1;
        int removedNum;

       
        while((removedNum = k % n) != m % n) {
            if(removedNum < m) {
                m -= removedNum;
            } else {
                m = (m + n) - removedNum;
            }

            n--;
            answer++;
        }

        System.out.println(answer);
    }

    public static void main(String[] args) {
        input();
        solution();
    }

    static class Reader {
        BufferedReader br;
        StringTokenizer st;

        public Reader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while(st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}