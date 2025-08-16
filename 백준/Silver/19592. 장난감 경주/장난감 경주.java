import java.io.*;
import java.util.*;

public class Main {

    // 단독 1등 가능 여부 판단 함수
    // Z: 부스터 속도 (1초 동안 이동 거리)
    // X: 트랙 길이
    // Vn: 내 기본 속도
    // minRivalTime: 라이벌 최단 완주 시간
    static boolean canWin(long Z, long X, long Vn, double minRivalTime) {
        if (Z > X) Z = X;

        double myTime = 1.0 + (X - Z) * 1.0 / Vn;
        return myTime < minRivalTime;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();

        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            long X = Long.parseLong(st.nextToken());
            long Y = Long.parseLong(st.nextToken());

            st = new StringTokenizer(br.readLine());
            long[] V = new long[N];
            for (int i = 0; i < N; i++) {
                V[i] = Long.parseLong(st.nextToken());
            }

            long Vn = V[N - 1]; // 내 기본 속도

            // 참가자들 중 나 뺴고 가장 빨리 완주하는 사람의 시간 구하기
            double minRivalTime = Double.MAX_VALUE;
            for (int i = 0; i < N - 1; i++) {
                double rivalTime = (double) X / V[i];
                minRivalTime = Math.min(minRivalTime, rivalTime);
            }

            // 부스터 없이도 단독 1위 가능한지
            double noBoostTime = (double) X / Vn;
            if (noBoostTime < minRivalTime) {
                out.append("0\n");
                continue;
            }

            // 부스터 최대치로도 단독 1위 불가능한 경우
            double maxBoostTime = 1.0 + (X - Math.min(Y, X)) * 1.0 / Vn;
            if (!(maxBoostTime < minRivalTime)) {
                out.append("-1\n");
                continue;
            }

            long lo = 1;
            long hi = Math.min(Y, X);
            long ans = -1;

            while (lo <= hi) {
                long mid = (lo + hi) >>> 1; // 부스터 속도 후보
                if (canWin(mid, X, Vn, minRivalTime)) {
                    ans = mid;
                    hi = mid - 1;
                } else {
                    lo = mid + 1; 
                }
            }

            out.append(ans).append('\n');
        }

        System.out.print(out);
    }
}
