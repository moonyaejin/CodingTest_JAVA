import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            sc.nextLine(); // 줄바꿈 처리

            String[] numbers = new String[n];
            for (int i = 0; i < n; i++) {
                numbers[i] = sc.nextLine();
            }

            Arrays.sort(numbers);  // 사전순 정렬

            boolean isConsistent = true;
            for (int i = 0; i < n - 1; i++) {
                if (numbers[i + 1].startsWith(numbers[i])) {
                    isConsistent = false;
                    break;
                }
            }

            System.out.println(isConsistent ? "YES" : "NO");
        }
    }
}
