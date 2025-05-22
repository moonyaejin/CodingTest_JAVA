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

            int[] busStops = new int [5001];

            for (int i = 0; i < N; i++) {
                int A = sc.nextInt();
                int B = sc.nextInt();

                busStops[A]++;
                if (B + 1 <= 5000) busStops[B + 1]--;
            }

            for (int i = 1; i <= 5000; i++) {
                busStops[i] += busStops[i - 1];
            }

            int P = sc.nextInt();
            System.out.print("#" + test_case);
            for (int i = 0; i < P; i++) {
                int C = sc.nextInt();
                System.out.print(" " + busStops[C]);
            }
            System.out.println();
		}
	}
}