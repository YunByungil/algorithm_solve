import java.util.*;
import java.io.*;

public class Main {
    public static int n, max, result, answer;
    public static int[] dx = {0, 0, -1, 1};
    public static int[] dy = {-1, 1, 0, 0};
    public static boolean[][] visit;
    public static int[][] arr, arr2;
    public static Queue<int[]> q = new LinkedList<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        arr2 = new int[n][n];
        visit = new boolean[n][n];
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                arr2 = arr;
                max = Math.max(max, arr[i][j]);
            }
        }
        
        
        for (int count = 0; count <= max; count++) {
            result = 0;
            block(count);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visit[i][j]) {
                        result++;
                        bfs(i, j);                        
                    }
                }
            }
            arr2 = arr;
            visit = new boolean[n][n];
            
            answer = Math.max(result, answer);
        }
        
        System.out.println(answer);
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
                
                if (newX < 0 || newX >= n || newY < 0 || newY >= n) {
                    continue;
                }
                
                if (!visit[newX][newY]) {
                    q.offer(new int[]{newX, newY});
                    visit[newX][newY] = true;
                }
            }
            
            
            
        }
    }
    
    public static void block(int num) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr2[i][j] <= num) {
                    visit[i][j] = true;
                }
            }
        }
    }
}
