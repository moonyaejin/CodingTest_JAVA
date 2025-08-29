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

        Stack<Integer> stack = new Stack<>();

        for (int i = heights.length - 1; i >= 0; i--) {
            if (stack.isEmpty() || heights[i] > stack.peek()) {  //맨 위(top)의 값을 꺼내 확인만 하고 제거하지 않음
                stack.push(heights[i]);
            }
        }

        System.out.println(stack.size());
    }
}