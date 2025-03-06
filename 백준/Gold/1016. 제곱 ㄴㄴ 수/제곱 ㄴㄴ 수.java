import java.util.*;

class Main {
    public static int countSquareFreeNumbers(long min, long max) {
        int size = (int) (max - min + 1);
        boolean[] isNotSquareFree = new boolean[size]; // 기본값 false (제곱ㄴㄴ수)

        // 2², 3², 4², ..., √max 까지의 제곱수를 이용하여 체크
        for (long i = 2; i * i <= max; i++) {
            long square = i * i; // 제곱수

            // min 이상에서 가장 가까운 square의 배수 찾기
            long start = ((min % square) == 0) ? min : (min / square + 1) * square;

            // square의 배수를 체크
            for (long j = start; j <= max; j += square) {
                if (j - min < size) {  // 배열 인덱스 범위 초과 방지
                    isNotSquareFree[(int) (j - min)] = true;
                }
            }
        }

        // 제곱ㄴㄴ수 개수 카운트
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (!isNotSquareFree[i]) count++;
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long min = sc.nextLong();
        long max = sc.nextLong();
        sc.close();

        System.out.println(countSquareFreeNumbers(min, max));
    }
}
