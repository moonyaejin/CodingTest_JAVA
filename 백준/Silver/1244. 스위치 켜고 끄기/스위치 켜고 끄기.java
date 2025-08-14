import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        // 스위치 상태 입력
        int[] state = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            state[i] = Integer.parseInt(st.nextToken());
        }

        // 학생 수 입력
        int student = Integer.parseInt(br.readLine());

        // 학생 별 처리
        for (int j = 0; j < student; j++) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int number = Integer.parseInt(st.nextToken());

            // 남자인 경우
            if (gender == 1) {
                int k = number;
                while (k <= N) {
                    state[k] = 1 - state[k];
                    k += number;
                }
            } else {     // 여자인 경우
                int left = number;
                int right = number;

                while (left - 1 >= 1 && right + 1 <= N && state[left - 1] == state[right + 1]) {
                    left--;
                    right++;
                }

                    for (int l = left; l <= right; l++) {
                        state[l] = 1 - state[l];
                    }
                }
        }
        StringBuilder sb = new StringBuilder();
        
        for (int i = 1; i <= N; i++) {
            sb.append(state[i]).append(" ");
            if (i % 20 == 0) sb.append("\n");
        }
        System.out.print(sb.toString());
    }
}
