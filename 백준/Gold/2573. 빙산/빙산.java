import java.util.*;
import java.io.*;

public class Main {
    public static int n, m;
    public static int[] dx = {0, 0, -1, 1};
    public static int[] dy = {-1, 1, 0, 0};
    public static boolean[][] visit;
    public static int[][] arr, copy;
    public static Queue<int[]> q = new LinkedList<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        copy = new int[n][m];
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int num = Integer.parseInt(st.nextToken());
                arr[i][j] = num;
                copy[i][j] = num;
            }
        }
        
        int answer = 0;
        while (true) {
            q = new LinkedList<>();
            visit = new boolean[n][m];
            answer++;
            bfs();
            
            int ch = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (!visit[i][j] && arr[i][j] != 0) {
                        check(i, j);
                        ch++;
                    }
                }
            }
            
            if (ch > 1) {
                System.out.println(answer);
                break;
            }
            
            boolean game = false;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (arr[i][j] != 0) {
                        game = true;
                    }
                }
            }
            
            if (!game) {
                System.out.println(0);
                break;
            }
            
        }
        
        
        
    }
    
    public static void bfs() {
        copy = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0) {
                    continue;
                }
                
                for (int k = 0; k < 4; k++) {
                    int newX = i + dx[k];
                    int newY = j + dy[k];

                    if (newX < 0 || newX >= n || newY < 0 || newY >= m) {
                        continue;
                    }

                    if (arr[newX][newY] == 0) {
                        copy[i][j]++;
                    }
                }
            }
        }
        
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = Math.max(0, arr[i][j] - copy[i][j]);
            }
        }
        
    }
    
    public static void check(int x, int y) {
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
                
                if (!visit[newX][newY] && arr[newX][newY] != 0) {
                    q.offer(new int[]{newX, newY});
                    visit[newX][newY] = true;
                }
            }
        }
    }
}
