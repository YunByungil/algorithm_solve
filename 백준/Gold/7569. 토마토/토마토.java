import java.util.*;
import java.io.*;

public class Main {
    public static int n, m, h, answer;
    public static int[] dx = {0, 0, -1, 1};
    public static int[] dy = {-1, 1, 0, 0};
    public static int[] dz = {1, -1};
    public static boolean[][][] visit;
    public static int[][][] arr;
    public static Queue<int[]> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken()); // 가로
        n = Integer.parseInt(st.nextToken()); // 세로
        h = Integer.parseInt(st.nextToken()); // 상자 개수
        
        arr = new int[h][n][m];
        visit = new boolean[h][n][m];
        for (int k = 0; k < h; k++) {
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < m; j++) {
                    int num = Integer.parseInt(st.nextToken());
                    arr[k][i][j] = num;
                    if (num == 1) {
                        q.offer(new int[]{k, i, j});
                    }
                }
            }
        }
        
        // for (int k = 0; k < h; k++) {
        //     for (int i = 0; i < n; i++) {
        //         for (int j = 0; j < m; j++) {
        //             if (!visit[k][i][j] && arr[k][i][j] == 1) {
        //                 bfs(k, i, j);
        //             }
        //         }
        //     }
        // }
        bfs();
        
        for (int k = 0; k < h; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (arr[k][i][j] == 0) {
                        System.out.println(-1);
                        return;
                    }
                    answer = Math.max(answer, arr[k][i][j]);
                    // System.out.print(arr[k][i][j] + " ");
                }
                // System.out.println();
            }
        }
        
        System.out.println(answer - 1);
        
    }
    
    public static void bfs() {
        // q.offer(new int[]{z, x, y});
        // visit[z][x][y] = true;
        
        while (!q.isEmpty()) {
            int[] nowLocation = q.poll();
            int nowZ = nowLocation[0];
            int nowX = nowLocation[1];
            int nowY = nowLocation[2];
            
            for (int i = 0; i < 4; i++) {
                int newX = nowX + dx[i];
                int newY = nowY + dy[i];
                
                if (newX < 0 || newX >= n || newY < 0 || newY >= m) {
                    continue;
                }
                
                if (!visit[nowZ][newX][newY] && arr[nowZ][newX][newY] == 0) {
                    q.offer(new int[]{nowZ, newX, newY});
                    visit[nowZ][newX][newY] = true;
                    arr[nowZ][newX][newY] = arr[nowZ][nowX][nowY] + 1;
                }
                
                for (int j = 0; j < 2; j++) {
                    int newZ = nowZ + dz[j];
                
                    if (newZ < 0 || newZ >= h) {
                        continue;
                    }
                
                    if (!visit[newZ][nowX][nowY] && arr[newZ][nowX][nowY] == 0) {
                        q.offer(new int[]{newZ, nowX, nowY});
                        visit[newZ][nowX][nowY] = true;
                        arr[newZ][nowX][nowY] = arr[nowZ][nowX][nowY] + 1;
                    }
                }  
            }
            
            
            
            
        }
    }
}
