import java.io.*;

public class Main {
    static String S, T;
    static boolean found = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        S = br.readLine();
        T = br.readLine();

        dfs(new StringBuilder(T)); 
        System.out.println(found ? 1 : 0);  
    }

    static void dfs(StringBuilder current) {
        if (found) return;

        if (current.length() == S.length()) {  // 길이가 같고
            if (current.toString().equals(S)) {  // 내용도 같으면 성공
                found = true;
            }
            return;
        }

        int len = current.length();

        // 마지막 문자가 A인 경우 → A를 제거하고 탐색
        if (current.charAt(len - 1) == 'A') {
            current.deleteCharAt(len - 1);  // A 삭제
            dfs(new StringBuilder(current));  // 삭제한 상태로 재귀 호출
            current.append('A');  // A 다시 붙여 원상복구
        }

        // 마지막 문자가 B인 경우 → B를 제거하고 뒤집은 후 탐색
        if (current.charAt(len - 1) == 'B') {
            current.deleteCharAt(len - 1);  // B 삭제
            current.reverse();  // 뒤집기
            dfs(new StringBuilder(current));  // 뒤집은 상태로 재귀 호출
            current.reverse();  // 다시 뒤집어서 원상복구
            current.append('B');  // 다시 B 붙여서 원상복구
        }
    }
}
