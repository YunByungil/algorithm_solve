import java.util.*;
import java.io.*;
public class Main {
    public static int n, m; // 세로 n, 가로 m
    public static int[][] arr; // 미로
    public static int[][] dir; // 최소 거리
    public static boolean[][] visit; // 방문 여부
    public static int[] col = {0, 0, 1, -1};
    public static int[] row = {1, -1, 0, 0};
    public static Queue<int[]> q = new LinkedList<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        arr = new int[n + 1][m + 1];
        visit = new boolean[n + 1][m + 1];
        
        dir = new int[n + 1][m + 1];
        dir[1][1] = 1;
        
        for (int i = 1; i <= n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j + 1] = str.charAt(j) - '0';
            }
        }
        
        bfs(1, 1);
        System.out.println(dir[n][m]);
        
    }
    
    public static void bfs(int y, int x) {
        q.offer(new int[]{y, x});
        visit[y][x] = true;
        
        while (!q.isEmpty()) {
            int[] nowLocation = q.poll();
            int nowY = nowLocation[0];
            int nowX = nowLocation[1];
            
            
            for (int i = 0; i < 4; i++) {
                int newY = nowY + row[i];
                int newX = nowX + col[i];
                
                if (newY <= 0 || newY > n || newX <= 0 || newX > m) {
                    continue;
                }
                
                if (!visit[newY][newX] && arr[newY][newX] == 1) {
                    if (dir[newY][newX] == 0) {
                        dir[newY][newX] = dir[nowY][nowX] + 1;
                    }                    
                    q.offer(new int[]{newY, newX});
                    visit[newY][newX] = true;
                }
            }
        }
    }
    
}