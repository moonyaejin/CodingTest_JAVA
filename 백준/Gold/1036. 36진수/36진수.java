import java.math.BigInteger;
import java.util.*;

public class Main {
    static int N, K; // 입력받을 숫자의 개수(N)와 변경할 문자 개수(K)
    static List<String> numbers = new ArrayList<>(); // 입력받은 숫자 리스트 (36진법 문자열 형태로 저장)
    
    // 문자별 기여도(값 증가량)를 저장하는 맵
    // A
    static Map<Character, BigInteger> gainMap = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 입력받기
        N = sc.nextInt(); // 숫자의 개수 입력
        for (int i = 0; i < N; i++) {
            numbers.add(sc.next()); // 36진법 숫자를 리스트에 저장
        }
        K = sc.nextInt(); // K개의 문자를 변경할 수 있음
        
        // 각 숫자의 자리별 기여도를 계산
        for (String num : numbers) {
            BigInteger base = BigInteger.ONE; // 현재 자리수 가중치 (36^0 = 1부터 시작)
            for (int i = num.length() - 1; i >= 0; i--) { // 오른쪽(1의 자리)부터 왼쪽(최상위 자리)까지 순회
                char c = num.charAt(i); // 현재 자리의 문자
                BigInteger curValue = BigInteger.valueOf(charToValue(c)); // 현재 문자의 10진수 값
                BigInteger newValue = BigInteger.valueOf(35); // Z(35)로 변경했을 때의 값
                
                // 기여도 = (35 - 현재값) * 자리수 가중치
                BigInteger gain = (newValue.subtract(curValue)).multiply(base);
                
                // 해당 문자의 기존 기여도에 누적 추가 (기존 기여도가 없으면 새로 추가)
                gainMap.put(c, gainMap.getOrDefault(c, BigInteger.ZERO).add(gain));
                
                base = base.multiply(BigInteger.valueOf(36)); // 자리수 증가 (36배)
            }
        }
        
        // 기여도가 높은 문자 K개 선택 (우선순위 큐 사용하여 정렬)
        PriorityQueue<Character> pq = new PriorityQueue<>(
            (a, b) -> gainMap.get(b).compareTo(gainMap.get(a)) // 기여도가 큰 순서대로 정렬 (내림차순)
        );
        pq.addAll(gainMap.keySet()); // 모든 문자를 우선순위 큐에 추가
        
        Set<Character> toChange = new HashSet<>(); // 변경할 문자 집합
        for (int i = 0; i < K && !pq.isEmpty(); i++) { // 최대 K개의 문자 선택
            toChange.add(pq.poll()); // 가장 기여도가 높은 문자부터 K개를 선택
        }
        
        // 숫자 변환 후 합산
        BigInteger totalSum = BigInteger.ZERO; // 모든 숫자의 합을 저장할 변수
        for (String num : numbers) {
            BigInteger base = BigInteger.ONE; // 자리수 가중치 (36^0 = 1부터 시작)
            BigInteger value = BigInteger.ZERO; // 변환된 10진수 값을 저장
            for (int i = num.length() - 1; i >= 0; i--) { // 오른쪽(1의 자리)부터 왼쪽(최상위 자리)까지 순회
                char c = num.charAt(i);
                int newVal = toChange.contains(c) ? 35 : charToValue(c); // 변경 대상 문자라면 Z(35)로 변환
                value = value.add(base.multiply(BigInteger.valueOf(newVal))); // 변환된 값 계산
                base = base.multiply(BigInteger.valueOf(36)); // 자리수 증가 (36배)
            }
            totalSum = totalSum.add(value); // 변환된 숫자를 총합에 추가
        }

        // 최종 합을 36진법으로 변환 후 출력
        System.out.println(totalSum.toString(36).toUpperCase()); // 대문자로 변환하여 출력
    }

    // 문자(char)를 36진수 값으로 변환하는 함수
    private static int charToValue(char c) {
        return Character.isDigit(c) ? c - '0' : c - 'A' + 10; // 0-9는 그대로, A-Z는 10-35로 변환
    }
}
