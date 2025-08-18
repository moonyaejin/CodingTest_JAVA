import java.io.*;
import java.util.*;

public class Main {

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
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        StringBuilder out = new StringBuilder();

        while (T-- > 0) {
            // n, m 입력
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            // A 입력
            int[] A = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                while (!st.hasMoreTokens()) {
                    st = new StringTokenizer(br.readLine());
                }
                A[i] = Integer.parseInt(st.nextToken());
            }

            // B 입력
            int[] B = new int[m];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                while (!st.hasMoreTokens()) {
                    st = new StringTokenizer(br.readLine());
                }
                B[i] = Integer.parseInt(st.nextToken());
            }

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

        System.out.print(out);
    }
}
