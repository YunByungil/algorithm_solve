import java.util.*;
import java.io.*;

public class Main {
    public static int t, l, answer;
    public static int[] dx = {1, 1, -1, -1, 2, 2, -2, -2};
    public static int[] dy = {2, -2, 2, -2, 1, -1, 1, -1};
    public static boolean[][] visit;
    public static int[][] arr;
    public static Queue<int[]> q = new LinkedList<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        t = Integer.parseInt(br.readLine());
        for (int count = 0; count < t; count++) {
            l = Integer.parseInt(br.readLine());
            arr = new int[l][l];
            visit = new boolean[l][l];
            
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            
            bfs(x, y);
            
            st = new StringTokenizer(br.readLine());
            int resultX = Integer.parseInt(st.nextToken());
            int resultY = Integer.parseInt(st.nextToken());
            
            System.out.println(arr[resultX][resultY]);
        }
    }
    
    public static void bfs(int x, int y) {
        q.offer(new int[]{x, y});
        visit[x][y] = true;
        
        while (!q.isEmpty()) {
            int[] nowLocation = q.poll();
            int nowX = nowLocation[0];
            int nowY = nowLocation[1];
            
            for (int i = 0; i < 8; i++) {
                int newX = nowX + dx[i];
                int newY = nowY + dy[i];
                
                if (newX < 0 || newX >= l || newY < 0 || newY >= l) {
                    continue;
                }
                
                if(!visit[newX][newY]) {
                    q.offer(new int[]{newX, newY});
                    visit[newX][newY] = true;
                    arr[newX][newY] = arr[nowX][nowY] + 1;
                }
            }
        }
        
    }
}
