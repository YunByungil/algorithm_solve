import java.util.*;
import java.io.*;

public class Main {
    public static int m,n; // m: 가로, n: 세로
    public static int answer;
    public static int[] row = {1, -1, 0, 0};
    public static int[] col = {0, 0, 1, -1};
    
    public static int[][] arr; // 토마토 그래프
    public static int[][] result; // 날짜
    public static boolean[][] visit; 
    public static Queue<int[]> q = new LinkedList<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        
        arr = new int[n][m];
        visit = new boolean[n][m];
        result = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 1) {
                    q.offer(new int[]{i, j});
                    visit[i][j] = true;
                }
            }
        }
        bfs();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // System.out.print(arr[i][j] + " ");
                if (arr[i][j] == 0) {
                    answer = -1;
                }
            }
            // System.out.println();
        }
        System.out.println(answer);
        
    }
    
    public static void bfs() {
        while (!q.isEmpty()) {
            int[] nowLocation = q.poll();
            int nowY = nowLocation[0];
            int nowX = nowLocation[1];
            
            for (int i = 0; i < 4; i++) {
                int newY = nowY + row[i];
                int newX = nowX + col[i];
                
                if (newY < 0 || newY >= n || newX < 0 || newX >= m) {
                    continue;
                }
                
                if (!visit[newY][newX] && arr[newY][newX] == 0) {
                    result[newY][newX] = result[nowY][nowX] + 1;
                    arr[newY][newX] = 1;
                    q.offer(new int[]{newY, newX});
                    visit[newY][newX] = true;
                    answer = result[newY][newX];
                }
            }
        }
        
    }
    
    
    
    
    
}