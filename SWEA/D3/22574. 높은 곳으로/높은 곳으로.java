import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();
            int P = sc.nextInt();

            int ans1 = 0, ans2 = 0;
            for (int i = 1; i <= N; i++) {
                if (ans1 + i != P) ans1 += i;
                if (i != 1 && ans2 + i != P) ans2 += i;
            }

            System.out.println(Math.max(ans1, ans2));
        }
    }
}