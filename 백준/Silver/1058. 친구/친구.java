import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());  // 사람 수
        char[][] friends = new char[N][N];  // 친구 관계를 저장할 2차원 배열

        // 친구 관계 입력 받기
        for (int i = 0; i < N; i++) {
            friends[i] = br.readLine().toCharArray();  // 한 줄씩 입력받아 문자열 배열로 변환
        }

        int maxFriends = 0;  // 가장 많은 2-친구수를 저장하는 배열

        // 모든 사람(0 ~ N-1)에 대해 BFS 실행
        for (int i = 0; i < N; i++) {
            // BFS 탐색을 위한 큐 ({현재 사람 번호, 탐색 깊이})
            Queue<int[]> queue = new LinkedList<>();
            
            // 방문 여부를 저장하는 배열 (중복 탐색 방지)
            boolean[] visited = new boolean[N];
            
            // 시작점을 큐에 추가 (현재 사람 i, 깊이 0)
            queue.add(new int[]{i, 0});  // {현재 사람, 거리(깊이)}
            visited[i] = true;

            int friendCount = 0;  // 현재 사람의 2-친구 수를 저장하는 변수

            // BFS 탐색
            while (!queue.isEmpty()) {
                int[] current = queue.poll();  // 큐에서 현재 탐색할 사람을 꺼냄
                int person = current[0];  // 현재 탐색 중인 사람
                int depth = current[1];  // 현재 탐색 깊이

                // 2단계까지만 탐색 
                if (depth >= 2) continue;  // 2단계까지만 탐색

                // 현재 사람과 친구 관계 확인
                for (int j = 0; j < N; j++) {
                    
                    // friends[person][j] == 'Y' -> 현재 사람이 j번 사람과 친구인가?
                    // !visited[j] -> j번 사람을 아직 방문하지 않았는가?
                    if (friends[person][j] == 'Y' && !visited[j]) {  // 친구 관계이고 방문 안 한 경우
                        queue.add(new int[]{j, depth + 1});  // 친구를 큐에 추가 (깊이+1)
                        visited[j] = true; // 방문 체크
                        friendCount++;  // 2-친구 수 증가
                    }
                }
            }

            maxFriends = Math.max(maxFriends, friendCount);  // 가장 큰 2-친구 수 갱신
        }

        System.out.println(maxFriends);
    }
}