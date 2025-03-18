import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // N 입력 받기
        int N = sc.nextInt();

        // 배열 A, B 선언 및 입력 받기
        int[] A = new int[N];
        int[] B = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }
        for (int i = 0; i < N; i++) {
            B[i] = sc.nextInt();
        }

        // A는 오름차순 정렬
        Arrays.sort(A);

        // B는 내림차순 정렬
        Integer[] B_desc = Arrays.stream(B).boxed().toArray(Integer[]::new); // int[] -> Integer[]
        Arrays.sort(B_desc, (x, y) -> y - x); // 내림차순 정렬

        // S 값 계산
        int S = 0;
        for (int i = 0; i < N; i++) {
            S += A[i] * B_desc[i];
        }

        // 결과 출력
        System.out.println(S);

        sc.close();
    }
}
