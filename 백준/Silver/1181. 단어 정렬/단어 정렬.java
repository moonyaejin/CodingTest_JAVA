import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        // 중복 단어 없어야 하므로 HashSet 사용
        Set<String> set = new HashSet<>();

        for (int i = 0; i < N; i++) {
            set.add(br.readLine());
        }

        // 리스트로 변환 후 정렬
        List<String> list = new ArrayList<>(set);

        Collections.sort(list, Comparator.comparingInt(String::length)
                                         .thenComparing(Comparator.naturalOrder()));

        StringBuilder sb = new StringBuilder();
        for (String s : list) {
            sb.append(s).append('\n');
        }
        System.out.print(sb);
    }
}
