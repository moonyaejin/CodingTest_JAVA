class Solution {
    int answer = 0;

    public int solution(int[] numbers, int target) {
        dfs(numbers, 0, 0, target);
        return answer;
    }

    // idx번째 숫자까지 고려했을 때의 현재 합(sum)
    void dfs(int[] numbers, int idx, int sum, int target) {
        // 모든 숫자를 다 사용한 경우
        if (idx == numbers.length) {
            if (sum == target) answer++;
            return;
        }

        // 현재 숫자를 더하는 경우
        dfs(numbers, idx + 1, sum + numbers[idx], target);

        // 현재 숫자를 빼는 경우
        dfs(numbers, idx + 1, sum - numbers[idx], target);
    }
}
