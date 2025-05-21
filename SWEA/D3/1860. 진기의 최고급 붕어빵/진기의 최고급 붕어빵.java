import java.util.*;
import java.io.*;


class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
            int N = sc.nextInt();
            int M = sc.nextInt();
            int K = sc.nextInt();

            int [] customerTime = new int[N];

            for (int i = 0; i < N; i++) {
                customerTime[i] = sc.nextInt();
            }

            Arrays.sort(customerTime);

            String result = "Possible";
            
            for (int i = 0; i < N; i++) {
                int bread = (customerTime[i] / M) * K;
                int customer = i + 1;

                if (bread < customer) {
                    result = "Impossible";
                    break;
                }
            }

            System.out.println("#" + test_case + " " + result);
		}
	}
}