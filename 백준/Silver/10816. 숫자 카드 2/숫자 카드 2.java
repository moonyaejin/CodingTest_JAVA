import java.io.*;
import java.util.*;

public class Main {
    static int lowerBound(int[] arr, int have) {
        int start = 0, end = arr.length;
        while (start < end) {
            int mid = (start + end) / 2;
            if (arr[mid] >= have) end = mid;
            else start = mid + 1;
        }
        return start;
    }

    static int upperBound(int[] arr, int have) {
        int start = 0, end = arr.length;
        while (start < end) {
            int mid = (start + end) / 2;
            if (arr[mid] > have) end = mid;
            else start = mid + 1;
        }
        return start;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));        
        int N = Integer.parseInt(br.readLine());
        int[] cards = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(cards);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < M; j++) {
            int have = Integer.parseInt(st.nextToken());
            int count = upperBound(cards, have) - lowerBound(cards, have);
            sb.append(count).append(' ');
        }
        System.out.println(sb.toString().trim());
    }
}
