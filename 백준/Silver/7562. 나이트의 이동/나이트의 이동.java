import java.util.*;
import java.io.*;

public class Main {
    public static int n, m, k, t, w, answer;
    // public static int[] dx = {0, 0, -1, 1};
    // public static int[] dy = {-1, 1, 0, 0};
    public static int[] dx = {1, 2, 1, 2, -1, -2, -1, -2};
    public static int[] dy = {-2, -1, 2, 1, -2, -1, 2, 1};
    public static int[][] arr;
    public static boolean[][] visit;
    // public static int[] arr;
    // public static boolean[] visit;
    public static Queue<int[]> q = new LinkedList<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));        
        StringTokenizer st = null;
        
        t = Integer.parseInt(br.readLine());
        for (int count = 0; count < t; count++) {
            n = Integer.parseInt(br.readLine());
            arr = new int[n][n];
            visit = new boolean[n][n];
            
            st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());
            
            st = new StringTokenizer(br.readLine());
            int endX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());
            
            q.offer(new int[]{startX, startY});
            visit[startX][startY] = true;
            
            bfs();
            System.out.println(arr[endX][endY]);
        }
        
    }
    
    public static void bfs() {
        while(!q.isEmpty()) {
            int[] nowLocation = q.poll();
            int nowX = nowLocation[0];
            int nowY = nowLocation[1];
            
            for (int i = 0; i < 8; i++) {
                int newX = nowX + dx[i];
                int newY = nowY + dy[i];
                
                if (newX < 0 || newX >= n || newY < 0 || newY >= n) {
                    continue;
                }
                
                if (!visit[newX][newY]) {
                    visit[newX][newY] = true;
                    arr[newX][newY] = arr[nowX][nowY] + 1;
                    q.offer(new int[]{newX, newY});
                }
            }
        }
    }
}
    
    
