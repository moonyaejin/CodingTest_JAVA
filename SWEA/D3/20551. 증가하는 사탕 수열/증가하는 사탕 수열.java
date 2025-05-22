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
            int A = sc.nextInt();
            int B = sc.nextInt();
            int C = sc.nextInt();

            int result = 0;

            if (C <= B) {
                int diff = B - C + 1;
                B -= diff;
                result += diff;
            }

            if (B <= A) {
                int diff = A - B + 1;
                A -= diff;
                result += diff; 
            }

            if (A <= 0 || B <= 0|| C <=0) {
                System.out.println("#" + test_case + " -1");
            } else {
                System.out.println("#" + test_case + " " + result);
            }
        }
        sc.close();
    }
}