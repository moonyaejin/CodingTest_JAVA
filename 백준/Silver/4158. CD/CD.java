import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();

        while (true) {
            String line = br.readLine();
            if (line == null) break;
            line = line.trim();
            if (line.isEmpty()) continue;

            StringTokenizer st = new StringTokenizer(line);
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            if (N == 0 && M == 0) break;

            int[] A = new int[N];
            int[] B = new int[M];

            for (int i = 0; i < N; i++) {
                A[i] = Integer.parseInt(br.readLine().trim());
            }
            for (int j = 0; j < M; j++) {
                B[j] = Integer.parseInt(br.readLine().trim());
            }

            int count = 0;

            if (N <= M) {
                for (int i = 0; i < N; i++) {
                    if (binarySearch(B, A[i])) count++;
                }
            } else {
                for (int j = 0; j < M; j++) {
                    if (binarySearch(A, B[j])) count++;
                }
            }

            out.append(count).append('\n');
        }

        System.out.print(out);
    }
    
    static boolean binarySearch(int[] arr, int key) {
        int low = 0, high = arr.length - 1;
        
        while (low <= high) {
            int mid = (low + high) >>> 1;
            if (arr[mid] == key) return true;
            if (arr[mid] < key) low = mid + 1;
            else high = mid - 1;
        }
        return false;
    }
}
