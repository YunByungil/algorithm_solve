import java.util.*;
import java.io.*;

public class Main {
    public static int n, m;
    public static int[][] arr, answer;
    public static boolean[][] visit;
    public static int[] dx = {0, 0, -1, 1};
    public static int[] dy = {-1, 1, 0, 0};
    public static Queue<int[]> q = new LinkedList<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        arr = new int[n][m];
        answer = new int[n][m];
        visit = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < input.length(); j++) {
                arr[i][j] = input.charAt(j) - '0';
            }
        }
        
        bfs(0, 0);
        System.out.println(answer[n - 1][m - 1] + 1);
    }
    
    public static void bfs(int x, int y) {
        q.offer(new int[]{x, y});
        visit[x][y] = true;
        
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
                    answer[newX][newY] = answer[nowX][nowY] + 1;
                    visit[newX][newY] = true;
                    q.offer(new int[]{newX, newY});
                }
            }
        }
    }
}
    
    
