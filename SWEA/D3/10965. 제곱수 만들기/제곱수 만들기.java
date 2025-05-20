import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int A = sc.nextInt();
            int originalA = A;
            int B = 1;

            for (int i = 2; i * i <= A; i++) {
                int count = 0;
                while (A % i == 0) {
                    A /= i;
                    count++;
                }
                if (count % 2 != 0) {
                    B *= i;
                }
            }

            if (A > 1) { 
                B *= A;
            }

            System.out.println("#" + test_case + " " + B);
        }
    }
}
