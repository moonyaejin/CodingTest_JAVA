import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int TestCase;
		TestCase=sc.nextInt();
		
		for(int test_case = 1; test_case <= TestCase; test_case++)
		{
            int N = sc.nextInt();
            int T = sc.nextInt();
            int P = sc.nextInt();

            int[][] solved = new int[N][T];
            int[] score = new int[T];
            int[] totalScores = new int[N];
            int[] solvedCounts = new int[N];
            int jihaksSolvedCount = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < T; j++) {
                    solved[i][j] = sc.nextInt();
                    if (solved[i][j] == 0) {  // 틀린 사람 수 계산 = 점수
                        score[j]++;
                    }
                }
            }

            for (int i = 0; i < N; i++) {
                int sum = 0;  
                int solvedCount = 0;  
                for (int j = 0; j < T; j++) {
                    if (solved[i][j] == 1) {
                        sum += score[j];
                        solvedCount++;
                    }
                }
                totalScores[i] = sum;
                solvedCounts[i] = solvedCount;
            }

            // 지학이 문제 수 세기 
            for (int j = 0; j < T; j++) {
                if (solved[P - 1][j] == 1) {
                    jihaksSolvedCount++;
                }
            }
            
            // 지학이 점수 계산
            int jihakScore = totalScores[P - 1];

            // 지학이보다 많은 점수를 획득한 참가자의 수
            int higherScoresCount = 0;
            int sameScoreMoreSolvedCount = 0;
            int sameScoreSameSolvedSmallerIdCount = 0;
            
            for (int i = 0; i < N; i++) {
                if (totalScores[i] > jihakScore) {
                    higherScoresCount++;
                }
            }
            
            // 지학이와 같은 점수를 획득했지만, 더 많은 문제를 푼 참가자의 수
            for (int i = 0; i < N; i++) {
                if(totalScores[i] == jihakScore && solvedCounts[i] > jihaksSolvedCount) {
                    sameScoreMoreSolvedCount++;
                }
            }
            
            // 자신과 같은 점수를 획득하고 같은 수의 문제를 풀었지만 번호가 더 작은 참가자의 수
            for (int i = 0; i < N; i++) {
                if(totalScores[i] == jihakScore && solvedCounts[i] == jihaksSolvedCount && i < (P - 1)) {
                    sameScoreSameSolvedSmallerIdCount++;
                }
            }

            int rank = higherScoresCount + sameScoreMoreSolvedCount + sameScoreSameSolvedSmallerIdCount + 1;
            System.out.println("#" + test_case + " " + jihakScore + " " + rank);

		}
	}
}