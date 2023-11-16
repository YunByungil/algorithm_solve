import java.util.*;
import java.io.*;

public class Main {
    public static int t, n, m, k;
    public static int answer = 0;
    public static int[] dx = {0, 0, 1, -1};
    public static int[] dy = {-1, 1, 0, 0};
    public static boolean[][] visit;
    public static int[][] arr;
    public static Queue<int[]> q = new LinkedList<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        t = Integer.parseInt(br.readLine()); // 테스트 케이스
        
        
        
        for (int time = 0; time < t; time++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            answer = 0;
            arr = new int[n][m];
            visit = new boolean[n][m];
            
            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                arr[x][y] = 1;
            }
            
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (!visit[i][j] && arr[i][j] == 1) {
                        answer++;
                        bfs(i, j);
                    }
                }
            }
            
            System.out.println(answer);
        }
        
    }
    
    public static void bfs(int x, int y) {
        visit[x][y] = true;
        q.offer(new int[]{x, y});
        
        while (!q.isEmpty()) {
            int[] nowLocation = q.poll();
            int nowX = nowLocation[0];
            int nowY = nowLocation[1];
            
            for (int i = 0; i < 4; i++) {
                int newX = nowX + dx[i];
                int newY = nowY + dy[i];
                
                if (newX < 0 || newX >= n || newY < 0 || newY >= m) {
                    continue;
                }
                
                if (!visit[newX][newY] && arr[newX][newY] == 1) {
                    visit[newX][newY] = true;
                    q.offer(new int[]{newX, newY});
                }
            }
        }
    }
}
