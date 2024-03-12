import java.util.*;
import java.io.*;

public class Main {
    public static int n, m;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static boolean[][] visit;
    public static int[][] arr, result;
    public static Queue<int[]> q = new LinkedList<>();
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        result = new int[n][m];
        visit = new boolean[n][m];
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 1) {
                    result[i][j] = 1;
                    visit[i][j] = true;
                    q.offer(new int[]{i, j});
                }
                if (arr[i][j] == -1) {
                    visit[i][j] = true;
                    result[i][j] = -1;
                }
            }
        }
        
        bfs();
        int answer = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (result[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
                // System.out.print(result[i][j] + " ");
                
                answer = Math.max(answer, result[i][j]);
            }
            // System.out.println();
        }
        
        System.out.println(answer - 1);
    }
    
    public static void bfs() {
        while (!q.isEmpty()) {
            int[] nowLocation = q.poll();
            int nowX = nowLocation[0];
            int nowY = nowLocation[1];
            // visit[nowX][nowY] = true;
            
            for (int i = 0; i < 4; i++) {
                int newX = nowX + dx[i];
                int newY = nowY + dy[i];
                
                if (newX < 0 || newX >= n || newY < 0 || newY >= m) {
                    continue;
                }
                
                if (arr[newX][newY] != -1 && !visit[newX][newY]) {
                    q.offer(new int[]{newX, newY});
                    result[newX][newY] = result[nowX][nowY] + 1;
                    visit[newX][newY] = true;
                }
            }
            
        }
    }
}