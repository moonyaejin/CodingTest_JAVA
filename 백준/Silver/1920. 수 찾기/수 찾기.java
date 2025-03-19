import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(); // 결과 출력을 위한 StringBuilder

        // 1. N 입력받기
        int N = Integer.parseInt(br.readLine());

        // 2. HashSet 선언 및 N개의 정수 입력받아 저장
        Set<Integer> set1 = new HashSet<>();
        String[] inputNumbers1 = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            set1.add(Integer.parseInt(inputNumbers1[i]));
        }

        // 3. M 입력받기
        int M = Integer.parseInt(br.readLine());

        // 4. List 선언 및 M개의 정수 입력받아 저장
        List<Integer> list = new ArrayList<>();
        String[] inputNumbers2 = br.readLine().split(" ");
        for (int i = 0; i < M; i++) {
            list.add(Integer.parseInt(inputNumbers2[i]));
        }

        // 5. M개의 수가 set1에 존재하는지 확인
        for (int i = 0; i < list.size(); i++) {
            if (set1.contains(list.get(i))) {
                sb.append("1\n");
            } else {
                sb.append("0\n");
            }
        }

        // 결과 출력
        System.out.print(sb.toString());
    }
}
