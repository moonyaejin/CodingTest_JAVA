import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int N = sc.nextInt();  // 모래시계 개수
            int B = sc.nextInt();  // 목표 시간
            int E = sc.nextInt();  // 허용 오차

            int count = 0;

            for (int i = 0; i < N; i++) {
                int xi = sc.nextInt();
                int mod = B % xi;

                if (mod <= E || xi - mod <= E) {
                    count++;
                }
            }

            System.out.println("#" + test_case + " " + count);
        }
    }
}
