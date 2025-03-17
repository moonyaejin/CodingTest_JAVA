import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final double PI = 3.141592653589793;
        String line;

        while ((line = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(line);

            double x1 = Double.parseDouble(st.nextToken());
            double y1 = Double.parseDouble(st.nextToken());
            double x2 = Double.parseDouble(st.nextToken());
            double y2 = Double.parseDouble(st.nextToken());
            double x3 = Double.parseDouble(st.nextToken());
            double y3 = Double.parseDouble(st.nextToken());

            // 예외 처리: 세 점이 일직선인 경우 "INVALID" 출력
            if (isCollinear(x1, y1, x2, y2, x3, y3)) {
                System.out.println("INVALID");
                continue;
            }

            // 원의 중심 구하기
            double[] center = getCircleCenter(x1, y1, x2, y2, x3, y3);
            double h = center[0], k = center[1];

            // 반지름 계산 (원의 중심과 첫 번째 점 사이의 거리)
            double r = Math.sqrt((x1 - h) * (x1 - h) + (y1 - k) * (y1 - k));

            // 원주 계산
            double circumference = 2 * PI * r;

            // 소수 둘째 자리까지 반올림하여 출력
            System.out.printf("%.2f%n", circumference);
        }
    }

    // 세 점이 일직선인지 확인하는 함수
    public static boolean isCollinear(double x1, double y1, double x2, double y2, double x3, double y3) {
        double area = x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2);
        return Math.abs(area) < 1e-9; // 부동소수점 오차 고려
    }

    // 세 점을 지나는 원의 중심을 구하는 함수 (행렬식을 이용한 수학적 계산)
    public static double[] getCircleCenter(double x1, double y1, double x2, double y2, double x3, double y3) {
        double a1 = x1 - x2;
        double b1 = y1 - y2;
        double c1 = (x1 * x1 - x2 * x2 + y1 * y1 - y2 * y2) / 2.0;

        double a2 = x1 - x3;
        double b2 = y1 - y3;
        double c2 = (x1 * x1 - x3 * x3 + y1 * y1 - y3 * y3) / 2.0;

        double d = a1 * b2 - a2 * b1;
        double h = (c1 * b2 - c2 * b1) / d;
        double k = (a1 * c2 - a2 * c1) / d;

        return new double[]{h, k};
    }
}
