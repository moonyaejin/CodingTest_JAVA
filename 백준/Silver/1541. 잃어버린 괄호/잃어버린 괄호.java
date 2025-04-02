import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine(); // 수식 입력 (예: 55-50+40)

        // '-' 기준으로 분리
        String[] subtractions = input.split("-");

        int result = 0;

        // 첫 번째 덩어리는 무조건 더해줌
        result += sumOf(subtractions[0]);

        // 두 번째 덩어리부터는 모두 빼줌
        for (int i = 1; i < subtractions.length; i++) {
            result -= sumOf(subtractions[i]);
        }

        System.out.println(result);
    }

    // '+'로 이루어진 부분을 나눠서 합을 계산하는 함수
    private static int sumOf(String expr) {
        String[] parts = expr.split("\\+"); // +는 정규식 특수문자라 \\ 필요
        int sum = 0;
        for (String num : parts) {
            sum += Integer.parseInt(num);
        }
        return sum;
    }
}
