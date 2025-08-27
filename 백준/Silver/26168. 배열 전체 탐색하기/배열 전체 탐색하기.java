import java.util.*;
import java.io.*;

public class Main {

    static int lowerBound(long[] arr, long x) {
        int left = 0;
        int right = arr.length;

        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] >= x) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    static int upperBound(long[] arr, long x) {
        int left = 0;
        int right = arr.length;

        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] > x) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        long[] A = new long[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            A[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(A);

        for (int q = 0; q < m; q++) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());

            if (type == 1) {
                long k = Long.parseLong(st.nextToken());
                int ans = n - lowerBound(A, k);
                System.out.println(ans);
            } 
            else if (type == 2) {
                long k = Long.parseLong(st.nextToken());
                int ans = n - upperBound(A, k);
                System.out.println(ans);
            } 
            else if (type == 3) {
                long i = Long.parseLong(st.nextToken());
                long j = Long.parseLong(st.nextToken());
                int ans = upperBound(A, j) - lowerBound(A, i);
                System.out.println(ans);
            }
        }
    }
}
