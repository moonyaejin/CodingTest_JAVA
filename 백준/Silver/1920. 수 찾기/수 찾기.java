import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // N 입력받기
        int N = Integer.parseInt(br.readLine());

        // N개의 정수 입력받아 저장
        Set<Integer> set1 = new HashSet<>(); // 수정: Set<Integer> (대문자 S)
        String[] inputNumbers1 = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            set1.add(Integer.parseInt(inputNumbers1[i]));
        }

        // M 입력받기
        int M = Integer.parseInt(br.readLine());

        // M개의 정수 입력받아 저장
        List<Integer> list = new ArrayList<>(); // 수정: ArrayList<> (대문자 A)
        String[] inputNumbers2 = br.readLine().split(" ");
        for (int i = 0; i < M; i++) {
            list.add(Integer.parseInt(inputNumbers2[i]));
        }

        // M개의 수가 set1에 존재하는지 확인
        for (int i = 0; i < list.size(); i++) { // 수정: i < list.size(); (공백 추가)
            if (set1.contains(list.get(i))) {
                sb.append("1\n");
            } else {
                sb.append("0\n");
            }
        }

        System.out.print(sb.toString());
    }
}
