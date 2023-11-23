import java.util.*;
import java.io.*;

public class Main {
    public static int n, m;
    public static int[] dx = {0, 0, -1, 1};
    public static int[] dy = {-1, 1, 0, 0};
    public static boolean[][] visit;
    public static char[][] arr;
    public static int[][] dis1;
    public static int[][] dis2;
    public static Queue<int[]> q1 = new LinkedList<>();
    public static Queue<int[]> q2 = new LinkedList<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        arr = new char[n][m];
        visit = new boolean[n][m];
        dis1 = new int[n][m];
        dis2 = new int[n][m];
        
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = input.charAt(j);
                dis1[i][j] = -1;
                dis2[i][j] = -1;
                if (arr[i][j] == 'F') {
                    q1.offer(new int[]{i, j});
                    dis1[i][j] = 0;
                }
                
                if (arr[i][j] == 'J') {
                    q2.offer(new int[]{i, j});
                    dis2[i][j] = 0;
                }
            }
        }
        
        // 불에 대한 BFS
        while (!q1.isEmpty()) {
            int[] nowLocation = q1.poll();
            int nowX = nowLocation[0];
            int nowY = nowLocation[1];
            
            for (int i = 0; i < 4; i++) {
                int newX = nowX + dx[i];
                int newY = nowY + dy[i];
                
                if (newX < 0 || newX >= n || newY < 0 || newY >= m) {
                    continue;
                }
                
                if (dis1[newX][newY] >= 0 || arr[newX][newY] == '#') {
                    continue;
                }
                
                dis1[newX][newY] = dis1[nowX][nowY] + 1;
                q1.offer(new int[]{newX, newY});
            }
        }
        
        // 지훈이에 대한 BFS
        while (!q2.isEmpty()) {
            int[] nowLocation = q2.poll();
            int nowX = nowLocation[0];
            int nowY = nowLocation[1];
            
            for (int i = 0; i < 4; i++) {
                int newX = nowX + dx[i];
                int newY = nowY + dy[i];
                
                if (newX < 0 || newX >= n || newY < 0 || newY >= m) {
                    System.out.println(dis2[nowX][nowY] + 1);
                    return;
                }
                
                if (dis2[newX][newY] >= 0 || arr[newX][newY] == '#') {
                    continue;
                }
                
                if (dis1[newX][newY] != -1 && dis1[newX][newY] <= dis2[nowX][nowY] + 1) {
                    continue;
                }
                
                q2.offer(new int[]{newX, newY});
                dis2[newX][newY] = dis2[nowX][nowY] + 1;
            }
        }
        
        System.out.println("IMPOSSIBLE");
        
        
    }
}
