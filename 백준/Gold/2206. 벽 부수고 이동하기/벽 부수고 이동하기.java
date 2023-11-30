import java.util.*;
import java.io.*;

public class Main {
    public static boolean state;
    public static int n, m;
    public static int answer = Integer.MAX_VALUE;
    public static int[] dx = {0, 0, -1, 1};
    public static int[] dy = {-1, 1, 0, 0};
    public static boolean[][][] visit;
    public static int[][] arr;
    public static int[][] result;
    public static Queue<int[]> q = new LinkedList<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        visit = new boolean[n][m][2];
        arr = new int[n][m];
        result = new int[n][m];
        
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                int num = input.charAt(j) - '0';
                arr[i][j] = num;
            }
        }
        
        answer = bfs();
        
        if (n - 1 == 0 && m - 1 == 0) {
            System.out.println(1);
        } else {
            System.out.println(answer);
        }
    }
    
    public static int bfs() {
        q.offer(new int[]{0, 0, 0});
        while (!q.isEmpty()) {
            int[] nowLocation = q.poll();
            int nowX = nowLocation[0];
            int nowY = nowLocation[1];
            int crashed = nowLocation[2];
            
            for (int i = 0; i < 4; i++) {
                int newX = nowX + dx[i];
                int newY = nowY + dy[i];
                
                if (newX < 0 || newX >= n || newY < 0 || newY >= m) {
                    continue;
                }
                
                if (arr[newX][newY] == 1) {
                    if (crashed == 0 && !visit[newX][newY][1]) {
                        visit[newX][newY][crashed] = true;
                        result[newX][newY] = result[nowX][nowY] + 1;
                        q.offer(new int[]{newX, newY, 1});
                    }
                } else {
                    if (!visit[newX][newY][crashed]) {
                        visit[newX][newY][crashed] = true;
                        result[newX][newY] = result[nowX][nowY] + 1;
                        q.offer(new int[]{newX, newY, crashed});
                    }
                }
                
                if (newX == n - 1 && newY == m - 1) {
                    return result[n - 1][m - 1] + 1;
                }
            }
        }
        
        return -1;
    }
}
