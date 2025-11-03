class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int n = schedules.length;
        int count = 0;
        int dayStart = startday - 1; // 0~6 범위로 변환

        for (int i = 0; i < n; i++) {
            int limit = toMinutes(schedules[i]) + 10;
            
            int j;
            for (j = 0; j < 7; j++) {
                int day = (dayStart + j) % 7;
                if (day >= 5) continue; // 토, 일 제외
                if (toMinutes(timelogs[i][j]) > limit) break; // 지각이면 탈락
            }

            if (j == 7 || (dayStart + j) % 7 >= 5) count++; 
        }

        return count;
    }

    private int toMinutes(int time) {
        return (time / 100) * 60 + (time % 100);
    }
}
