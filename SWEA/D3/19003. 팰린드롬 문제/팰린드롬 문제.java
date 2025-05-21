import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
            int N, M;
            
            N = sc.nextInt();
            M = sc.nextInt();
            sc.nextLine();

            String[] palindrome = new String[N];
            boolean[] used = new boolean[N];
            
            for (int i = 0; i < N; i++) {
                palindrome[i] = sc.nextLine();
            }

            int pairCount = 0;
            boolean center = false;

            for (int i = 0; i < N; i++) {
                if (used[i]) continue;

                for (int j = i + 1; j < N; j++) {
                    if (!used[j] && palindrome[i].equals(new StringBuilder(palindrome[j]).reverse().toString())) {
                        used[i] = true;
                        used[j] = true;
                        pairCount++;
                        break;
                    }
                }
            }

            for (int i = 0; i < N; i++) {
                if (!used[i] && isPalindrome(palindrome[i])) {
                    center = true;
                    break;
                }
            }

            int length = pairCount * 2 * M;
            if (center) length += M;
            
            System.out.println("#" + test_case + " " + length);
		}
	}

    static boolean isPalindrome(String s) {
        return s.equals(new StringBuilder(s).reverse().toString());
    }
}