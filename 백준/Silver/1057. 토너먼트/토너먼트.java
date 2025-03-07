import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();  // 참가자 수
        int a = sc.nextInt();  // 김지민의 번호
        int b = sc.nextInt();  // 임한수의 번호
        sc.close();

        int rounds = 0;

        // 두 번호가 같아질 때까지 반복
        while (a != b) {
            a = (a + 1) / 2;  // 다음 라운드 번호 계산
            b = (b + 1) / 2;
            rounds++;
        }

        System.out.println(rounds); // 대결하는 라운드 출력
    }
}
