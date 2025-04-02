import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수

        while (T-- > 0) {
            String p = br.readLine(); // 함수 문자열
            int n = Integer.parseInt(br.readLine());
            String input = br.readLine();

            Deque<Integer> deque = new ArrayDeque<>();

            // 문자열 파싱해서 숫자만 deque에 저장
            input = input.substring(1, input.length() - 1); 
            if (n > 0) {
                String[] nums = input.split(",");
                for (String num : nums) {
                    deque.add(Integer.parseInt(num));
                }
            }

            boolean isReversed = false; // 뒤집기 여부
            boolean isError = false; // 에러 발생 여부

            // 함수 문자열 하나씩 처리
            for (char cmd : p.toCharArray()) {
                if (cmd == 'R') {
                    isReversed = !isReversed; // 뒤집기
                } else if (cmd == 'D') {
                    if (deque.isEmpty()) {
                        isError = true;
                        break;
                    }
                    if (isReversed) {
                        deque.pollLast(); // 뒤에서 제거
                    } else {
                        deque.pollFirst(); // 앞에서 제거
                    }
                }
            }

            if (isError) {
                System.out.println("error");
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append('[');
                if (!deque.isEmpty()) {
                    if (isReversed) {
                        // 뒤집힌 상태면 뒤에서부터 출력
                        Iterator<Integer> iter = deque.descendingIterator();
                        while (iter.hasNext()) {
                            sb.append(iter.next()).append(',');
                        }
                    } else {
                        // 정방향 출력
                        Iterator<Integer> iter = deque.iterator();
                        while (iter.hasNext()) {
                            sb.append(iter.next()).append(',');
                        }
                    }
                    sb.deleteCharAt(sb.length() - 1); // 마지막 쉼표 제거
                }
                sb.append(']');
                System.out.println(sb);
            }
        }
    }
}
