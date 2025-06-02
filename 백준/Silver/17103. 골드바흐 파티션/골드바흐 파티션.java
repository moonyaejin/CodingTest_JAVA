import java.util.*;

public class Main {
    static boolean[] isNotPrime = new boolean[1000001]; // false = 소수, true = 소수 아님

    // 에라토스테네스의 체로 소수 구하기
    public static void sieve() {
        isNotPrime[0] = true;
        isNotPrime[1] = true;
        for (int i = 2; i * i <= 1000000; i++) {
            if (!isNotPrime[i]) {
                for (int j = i * i; j <= 1000000; j += i) {
                    isNotPrime[j] = true;
                }
            }
        }
    }

    // 골드바흐 파티션 개수
    public static int countGoldbach(int n) {
        int count = 0;
        for (int i = 2; i <= n / 2; i++) {
            if (!isNotPrime[i] && !isNotPrime[n - i]) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        sieve();

        int T = sc.nextInt();
        while (T-- > 0) {
            int N = sc.nextInt();
            System.out.println(countGoldbach(N));
        }
    }
}
