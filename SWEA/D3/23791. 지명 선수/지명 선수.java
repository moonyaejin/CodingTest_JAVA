import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
			
			int[] A = new int[N];
			int[] B = new int[N];
			
			for (int i = 0; i < N; i++) {
				A[i] = sc.nextInt();
			}
			for (int i = 0; i < N; i++) {
				B[i] = sc.nextInt();
			}
			
			boolean[] selected = new boolean[N + 1];
			char[] result = new char[N + 1];
			
			int aIndex = 0, bIndex = 0;
			boolean isATurn = true;
			int selectedCount = 0;
			
			while (selectedCount < N) {
				if (isATurn) {
					while (selected[A[aIndex]]) aIndex++;
					int pick = A[aIndex++];
					selected[pick] = true;
					result[pick] = 'A';
				} else {
					while (selected[B[bIndex]]) bIndex++;
					int pick = B[bIndex++];
					selected[pick] = true;
					result[pick] = 'B';
				}
				selectedCount++;
				isATurn = !isATurn;
			}
			
			// 결과 출력
			StringBuilder sb = new StringBuilder();
			for (int i = 1; i <= N; i++) {
				sb.append(result[i]);
			}
			System.out.println(sb.toString());
		}
	}
}
