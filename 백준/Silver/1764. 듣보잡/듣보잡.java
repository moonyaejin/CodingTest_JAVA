import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 듣도 못한 사람 수
        int M = Integer.parseInt(st.nextToken()); // 보도 못한 사람 수

        Set<String> unheard = new HashSet<>();
        List<String> unheardUnseen = new ArrayList<>();

        // 듣도 못한 사람 목록 입력
        for (int i = 0; i < N; i++) {
            unheard.add(br.readLine());
        }

        // 보도 못한 사람 입력받으며 듣도 못한 목록에 있는지 확인
        for (int i = 0; i < M; i++) {
            String name = br.readLine();
            if (unheard.contains(name)) { // 듣도 못한 사람 목록에 존재하면 듣보잡 리스트에 추가 (교집합)
                unheardUnseen.add(name);
            }
        }

        // 듣보잡 리스트 정렬
        Collections.sort(unheardUnseen);

        // 출력
        StringBuilder sb = new StringBuilder();
        sb.append(unheardUnseen.size()).append("\n");
        for (String name : unheardUnseen) {
            sb.append(name).append("\n");
        }
        System.out.print(sb);
    }
}
