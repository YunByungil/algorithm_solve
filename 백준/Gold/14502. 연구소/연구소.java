import java.util.*;
import java.io.*;

public class Main {
    public static int n, m;
    public static int answer;
    public static int[] dx = {1, -1, 0, 0};
    public static int[] dy = {0, 0, 1, -1};
    public static int[][] arr;
    public static int[][] copy;
    public static Queue<int[]> q = new LinkedList<>();
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        dfs(0);
        System.out.println(answer);
        
        
    }
    
    public static void dfs(int depth) {
        if (depth == 3) {
            bfs();
            return;
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0) {
                    arr[i][j] = 1;
                    dfs(depth + 1);
                    arr[i][j] = 0;
                }
            }
        }
    }
    
    public static void bfs() {
        checkVirus();
        copy = new int[n][m];
        
        for (int i = 0; i < n; i++) {
            copy[i] = arr[i].clone();
        }
        
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
                
                if (copy[newX][newY] == 0) {
                    copy[newX][newY] = 2;
                    q.offer(new int[]{newX, newY});
                }
            }
        }
        
        getMax();
    }
    
    public static void checkVirus() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 2) {
                    q.offer(new int[]{i, j});
                }
            }
        }
    }
    
    public static void getMax() {
        int result = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (copy[i][j] == 0) {
                    result++;
                }
            }
        }
        
        answer = Math.max(result, answer);
    }
    
}