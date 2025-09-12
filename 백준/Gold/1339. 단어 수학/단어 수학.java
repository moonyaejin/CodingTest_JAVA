import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        String[] words = new String[n];
        
        // 단어 입력 받기
        for (int i = 0; i < n; i++) {
            words[i] = br.readLine();
        }
        
        // 각 알파벳의 가중치를 저장할 맵
        Map<Character, Integer> weightMap = new HashMap<>();
        
        // 각 알파벳의 가중치 계산
        for (String word : words) {
            int digit = 1;
            // 단어를 뒤에서부터 읽으면서 자릿수 계산
            for (int i = word.length() - 1; i >= 0; i--) {
                char ch = word.charAt(i);
                weightMap.put(ch, weightMap.getOrDefault(ch, 0) + digit);
                digit *= 10;
            }
        }
        
        // 가중치를 리스트로 변환하고 정렬
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(weightMap.entrySet());
        // 가중치가 큰 순서대로 정렬
        list.sort((a, b) -> b.getValue() - a.getValue());
        
        // 각 알파벳에 숫자 할당 (9부터 시작)
        Map<Character, Integer> numberMap = new HashMap<>();
        int num = 9;
        for (Map.Entry<Character, Integer> entry : list) {
            numberMap.put(entry.getKey(), num);
            num--;
        }
        
        // 최종 합 계산
        int sum = 0;
        for (String word : words) {
            int wordValue = 0;
            for (char ch : word.toCharArray()) {
                wordValue = wordValue * 10 + numberMap.get(ch);
            }
            sum += wordValue;
        }
        
        System.out.println(sum);
    }
}