import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            String[] input = sc.nextLine().split(" ");
            int N = Integer.parseInt(input[0]);
            String X = input[1];

            int sum = 0;
            for (int i = 0; i < X.length(); i++) {
                sum += X.charAt(i) - '0'; 
            }

            int result = sum % (N - 1);
            System.out.println("#" + test_case + " " + result);
        }
    }
}
