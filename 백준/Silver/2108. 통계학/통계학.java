import java.util.*;
import java.io.*;

public class Main {
    // 산술평균
    public static int getArithmeticMean(int[] number, int N) {
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += number[i];
        }
        // 소수점 이하 첫째 자리에서 반올림한 값을 출력
        return (int) Math.round((double) sum / N);
    }
    // 중앙값
    public static int getMedian(int[] number, int N){
        int mid = N / 2;
        return number[mid];
    }
    // 최빈값
    public static int getMode(int[] number){
        int[] count = new int[8001];

        for (int n : number) {
            count[n + 4000]++;
        }

        int maxCount = 0;
        for (int c : count) {
            if (c > maxCount) {
                maxCount = c;
            }
        }

        List<Integer> modeList = new ArrayList<>();
        for (int i = 0; i < count.length; i++) {
            if (count[i] == maxCount) {
                modeList.add(i - 4000);
            }
        }

        if (modeList.size() == 1) {
        return modeList.get(0);
        } else {
            Collections.sort(modeList);
            return modeList.get(1);
        }
    }
    // 범위
    public static int getRange(int[] number, int N){
        int num1 = number[0];
        int num2 = number[N - 1];
        return num2 - num1;
    }
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] number = new int[N];
        for (int i = 0; i < N; i++) {
            number[i] = sc.nextInt();
        }

        // 오름차순 정렬
        Arrays.sort(number);
        
        System.out.println(getArithmeticMean(number, N));
        System.out.println(getMedian(number, N));
        System.out.println(getMode(number));
        System.out.println(getRange(number, N));
    }
}