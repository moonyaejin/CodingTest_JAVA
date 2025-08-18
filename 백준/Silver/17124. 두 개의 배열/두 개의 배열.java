import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            String line = br.readLine();
            if (line == null) return null;
            st = new StringTokenizer(line);
        }
        return st.nextToken();
    }

    static int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    static int lowerBound(int[] arr, int target) {
        int low = 0, high = arr.length;
        while (low < high) {
            int mid = (low + high) >>> 1;
            if (arr[mid] >= target) high = mid;
            else low = mid + 1;
        }
        return low;
    }

    public static void main(String[] args) throws Exception {
        StringBuilder out = new StringBuilder();

        int T = nextInt();
        while (T-- > 0) {
            int n = nextInt();
            int m = nextInt();

            int[] A = new int[n];
            int[] B = new int[m];

            for (int i = 0; i < n; i++) A[i] = nextInt();
            for (int i = 0; i < m; i++) B[i] = nextInt();

            Arrays.sort(B);

            long sum = 0L;
            for (int i = 0; i < n; i++) {
                int x = A[i];
                int idx = lowerBound(B, x);

                int chosen;
                if (idx == 0) {
                    chosen = B[0];
                } else if (idx == m) {
                    chosen = B[m - 1];
                } else {
                    int left = B[idx - 1];
                    int right = B[idx];
                    long dl = Math.abs((long) left - (long) x);
                    long dr = Math.abs((long) right - (long) x);
                    
                    chosen = (dl <= dr) ? left : right;
                }

                sum += chosen;
            }

            out.append(sum).append('\n');
        }

        System.out.print(out.toString());
    }
}
