import java.io.*;
import java.util.*; // StringTokenizer, Arrays

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        String A = st.nextToken();
        String B = st.nextToken();

        int N = A.length(), M = B.length();

        // B에서 알파벳(A~Z)의 첫 등장 행 인덱스를 기록하는 테이블
        int[] first = new int[26];
        
        // -1은 "아직 등장하지 않음"
        Arrays.fill(first, -1);

        // B를 스캔하며 첫 등장만 기록
        for (int j = 0; j < M; j++) {
            int idx = B.charAt(j) - 'A';  // 'A':0, 'B':1 ... 'Z':25
            if (first[idx] == -1) first[idx] = j; // 첫 등장일 때만 저장
        }

        // 교차점 찾기
        // A를 왼쪽부터 보면서 B에도 존재하는 첫 글자에서 확정
        int col = -1, row = -1;
        for (int i = 0; i < N; i++) { 
            int j = first[A.charAt(i) - 'A']; // B에서의 첫 등장 행
            if (j != -1) {   // B에도 존재한다면
                col = i;     // A에서의 위치(열)
                row = j;     // B에서의 위치(행)
                break;
            }
        }

        // 즉시 출력
        // 교차 행에는 A 그대로, 나머지는 교차 열만 B 글자, 나머지는 '.'
        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < M; k++) {
            if (k == row) {
                // 교차 행: A를 가로로 그대로 출력
                sb.append(A);
            } else {
                // 앞쪽 '.' * col
                sb.append(".".repeat(col));
                // 교차 열에 B의 해당 행 글자
                sb.append(B.charAt(k));
                // 뒤쪽 '.' * (N - col - 1)
                sb.append(".".repeat(N - col - 1));
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }
}
