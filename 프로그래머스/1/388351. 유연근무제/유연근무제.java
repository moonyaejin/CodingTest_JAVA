class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int n = schedules.length;
        int count = 0;

        // startday를 0~6으로 변환 (0=월, 5=토, 6=일)
        int dayStart = (startday - 1) % 7;

        for (int i = 0; i < n; i++) {
            int limit = toMinutes(schedules[i]) + 10;
            boolean ok = true;

            for (int j = 0; j < 7; j++) {
                int day = (dayStart + j) % 7;
                if (day >= 5) continue; // 5=토, 6=일

                if (toMinutes(timelogs[i][j]) > limit) {
                    ok = false;
                    break;
                }
            }
            if (ok) count++;
        }

        return count;
    }

    private int toMinutes(int time) {
        return (time / 100) * 60 + (time % 100);
    }
}
