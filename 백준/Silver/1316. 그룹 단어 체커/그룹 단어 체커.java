import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());

        int count = 0; 

        for (int i = 0; i < N; i++) {
            String word = br.readLine();

            // 그룹 단어이면 count 증가
            if (isGroupWord(word)) {
                count++;
            }
        }

        System.out.println(count);
    }

    static boolean isGroupWord(String word) {
        // 각 알파벳(a~z)이 이전에 등장했는지 여부를 저장하는 배열
        // true이면 이미 등장한 문자임
        boolean[] visited = new boolean[26];

        // 이전 문자 저장용 변수
        // 초기에는 null 문자(아스키 0)로 초기화
        char prev = 0;

        for (int i = 0; i < word.length(); i++) {
            char curr = word.charAt(i);

            // 현재 문자와 이전 문자가 다를 때에만 체크
            // 동일 문자가 연속될 때는 재검사 불필요
            if (curr != prev) {
                // 현재 문자가 이전에 이미 등장한 문자라면
                // 즉, 연속되지 않고 중간에 다른 문자로 끊기고 다시 나타난 경우임
                if (visited[curr - 'a']) {
                    return false; // 그룹 단어 조건 위반
                }

                // 현재 문자를 방문 처리 (이제부터 이 문자는 이미 등장한 상태)
                visited[curr - 'a'] = true;
            }

            // 현재 문자를 이전 문자 변수에 저장 (다음 문자와 비교 위해)
            prev = curr;
        }

        // 모두 검사 후 위반 없으면 그룹 단어임
        return true;
    }
}
