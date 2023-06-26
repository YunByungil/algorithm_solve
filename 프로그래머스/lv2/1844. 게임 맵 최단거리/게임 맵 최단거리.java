import java.util.*;

class Solution {
    public static int n, m;
    public static int[][] arr;
    public static boolean[][] visit;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static Queue<int[]> q = new LinkedList<>();
    
    public int solution(int[][] maps) {
        int answer = 0;
        n = maps.length;
        m = maps[0].length;
        arr = new int[n][m];
        visit = new boolean[n][m];
        
        bfs(maps);
        
        answer = arr[n - 1][m - 1];
        if (answer == 0) {
            answer = -1;
        } else {
            answer++;
        }
        return answer;
    }
    
    public static void bfs(int[][] maps) {
        q.offer(new int[]{0, 0});
        visit[0][0] = true;
        
        while (!q.isEmpty()) {
            int[] location = q.poll();
            int nowX = location[0];
            int nowY = location[1];
            
            for (int i = 0; i < 4; i++) {
                int newX = nowX + dx[i];
                int newY = nowY + dy[i];
                
                if (newX < 0 || newX >= n || newY < 0 || newY >= m) {
                    continue;
                }
                
                if (maps[newX][newY] == 1 && !visit[newX][newY]) {
                    q.offer(new int[]{newX, newY});
                    
                    visit[newX][newY] = true;
                    arr[newX][newY] = arr[nowX][nowY] + 1;
                }
            }
        }
    }
}