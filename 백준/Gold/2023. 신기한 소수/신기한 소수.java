import java.io.*;

public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        // 한자리 신기한 소수들로 시작 - 한자리 소수는 2 3 5 7
        int[] firstPrimes = {2, 3, 5, 7};
        for (int fp : firstPrimes) {
            dfs(fp, 1);
        }
    }

    // 재귀 탐색
    //  현재 숫자 cur, 현재 자릿수 length
    static void dfs(int cur, int length) {
        // 소수 아닌 경우 가지치기
        if (!isPrime(cur)) return;

        // N자리 신기한 소수 완성: 출력
        if (length == N) {
            System.out.println(cur);
            return;
        }

        // 다음 자릿수에 붙일 수 있는 숫자 - 1 3 5 7 9
        int[] nextDigits = {1, 3, 5, 7, 9};
        for (int d : nextDigits) {
            int nextNum = cur * 10 + d;
            dfs(nextNum, length + 1);
        }
    }

    // 소수 판별 함수
    static boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
