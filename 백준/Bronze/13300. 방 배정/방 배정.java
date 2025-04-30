import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();  // 학생 수
        int K = sc.nextInt();  // 방 최대 인원 수

        int[][] group = new int[2][7];  //[성별][학년]

        for (int i = 0; i < N; i++) {
            int S = sc.nextInt();  // 성별
            int Y = sc.nextInt();  // 학년
            group[S][Y]++;
        }

        int roomCount = 0;

        for (int s = 0; s <= 1; s++) {
            for (int y = 1; y <= 6; y++) {
                int students = group[s][y];
                roomCount += (students + K - 1) / K; 
            }
        }

        System.out.println(roomCount);
    }
}