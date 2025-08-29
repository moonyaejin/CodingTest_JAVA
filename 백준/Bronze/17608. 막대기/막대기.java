import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] heights = new int[N];

        for (int i = 0; i < heights.length; i++) {
            heights[i] = Integer.parseInt(br.readLine());
        }

        int count = 0;
        int maxHeight = 0;

        for (int i = heights.length - 1; i >= 0; i--) {
            if (heights[i] > maxHeight) {
                maxHeight = heights[i];
                count++;
            }
        }

        System.out.println(count);
    }
}