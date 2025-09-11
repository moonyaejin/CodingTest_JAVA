import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();

        int count0 = 0; // 0 그룹 개수
        int count1 = 0; // 1 그룹 개수

        // 첫 문자 기준으로 초기값 세팅
        if (S.charAt(0) == '0') count0++;
        else count1++;

        for (int i = 1; i < S.length(); i++) {
            if (S.charAt(i) != S.charAt(i - 1)) {
                // 이전과 달라질 때 그룹 수 증가
                if (S.charAt(i) == '0') count0++;
                else count1++;
            }
        }

        System.out.println(Math.min(count0, count1));
    }
}
