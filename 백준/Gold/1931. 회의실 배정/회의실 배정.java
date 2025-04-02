import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 회의 수

        // 회의 정보를 저장할 배열
        int[][] meetings = new int[N][2];

        // 입력받기
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            meetings[i][0] = Integer.parseInt(st.nextToken()); // 시작 시간
            meetings[i][1] = Integer.parseInt(st.nextToken()); // 종료 시간
        }

        // 종료 시간 기준 오름차순 정렬 (종료 시간이 같으면 시작 시간 오름차순)
        Arrays.sort(meetings, (a, b) -> {
            if (a[1] == b[1]) {
                return a[0] - b[0];
            } else {
                return a[1] - b[1];
            }
        });

        int count = 0; // 사용할 수 있는 회의 개수
        int endTime = 0; // 마지막으로 선택한 회의의 종료 시간

        for (int i = 0; i < N; i++) {
            // 현재 회의의 시작 시간이 이전 회의 종료 시간보다 같거나 크면 선택
            if (meetings[i][0] >= endTime) {
                count++;
                endTime = meetings[i][1]; // 종료 시간 갱신
            }
        }

        System.out.println(count); // 최대 회의 수 출력
    }
}
