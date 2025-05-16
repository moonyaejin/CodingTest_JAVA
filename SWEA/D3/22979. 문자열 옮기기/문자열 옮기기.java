import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            String s = sc.nextLine();
            int K = Integer.parseInt(sc.nextLine());
            String[] ops = sc.nextLine().split(" ");
            int len = s.length();

            Deque<Character> deque = new ArrayDeque<>();
            for (char c : s.toCharArray()) {
                deque.addLast(c);
            }

            for (int i = 0; i < K; i++) {
                int x = Integer.parseInt(ops[i]);

                int rot = x % len;
                if (rot > 0) {
                    for (int j = 0; j < rot; j++) {
                        deque.addLast(deque.removeFirst());
                    }
                } else if (rot < 0) {
                    for (int j = 0; j < -rot; j++) {
                        deque.addFirst(deque.removeLast());
                    }
                }
            }

            StringBuilder sb = new StringBuilder();
            for (char c : deque) {
                sb.append(c);
            }
            System.out.println(sb);
        }
    }
}
