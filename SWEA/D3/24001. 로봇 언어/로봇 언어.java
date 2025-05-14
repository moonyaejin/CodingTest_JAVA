import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            String input = sc.nextLine();

            int pos1 = 0;
            int maxDist1 = 0;
            for (char c : input.toCharArray()) {
                if (c == 'L') pos1--;
                else pos1++; 
                maxDist1 = Math.max(maxDist1, Math.abs(pos1));
            }

            int pos2 = 0;
            int maxDist2 = 0;
            for (char c : input.toCharArray()) {
                if (c == 'R') pos2++;
                else pos2--;
                maxDist2 = Math.max(maxDist2, Math.abs(pos2));
            }

            System.out.println(Math.max(maxDist1, maxDist2));
        }
    }
}
