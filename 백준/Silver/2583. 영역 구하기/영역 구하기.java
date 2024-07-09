import java.util.*;
import java.io.*;

public class Main {
    public static int n, m, k, t, w, answer;
    public static int[] dx = {0, 0, -1, 1};
    public static int[] dy = {-1, 1, 0, 0};
    // public static int[] dx = {1, 2, 1, 2, -1, -2, -1, -2};
    // public static int[] dy = {-2, -1, 2, 1, -2, -1, 2, 1};
    public static int[][] arr;
    public static boolean[][] visit;
    // public static int[] arr;
    // public static boolean[] visit;
    public static Queue<int[]> q = new LinkedList<>();
    public static List<Integer> list = new ArrayList<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));        
        StringTokenizer st = null;
        
        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        
        arr = new int[m + 1][n + 1];
        visit = new boolean[m + 1][n + 1];
        
        // m = 5 m - y를 해야 된다.
        for (int count = 0; count < k; count++) {
            st = new StringTokenizer(br.readLine());
            int leftX = Integer.parseInt(st.nextToken());
            int leftY = Integer.parseInt(st.nextToken());
            int rightX = Integer.parseInt(st.nextToken());
            int rightY = Integer.parseInt(st.nextToken());
            
            leftY = m - leftY - 1;
            rightY = m - rightY;
            rightX--;
            
            int leftMin = Math.min(leftY, rightY);
            int leftMax = Math.max(leftY, rightY);
            int rightMin = Math.min(leftX, rightX);
            int rightMax = Math.max(leftX, rightX);
            // System.out.println(leftMin + " " + leftMax + " " + rightMin + " " + rightMax);
            for (int i = leftMin; i <= leftMax; i++) {
                for (int j = rightMin; j <= rightMax; j++) {
                    visit[i][j] = true;
                }
            }
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visit[i][j]) {
                    visit[i][j] = true;
                    q.offer(new int[]{i, j});
                    bfs();
                }
            }
        }
        
        Collections.sort(list);
        System.out.println(list.size());
        for (Integer i : list) {
            System.out.print(i + " ");
        }
        
    }
    
    public static void bfs() {
        int result = 0;
        while(!q.isEmpty()) {
            result++;
            int[] nowLocation = q.poll();
            int nowX = nowLocation[0];
            int nowY = nowLocation[1];
            
            for (int i = 0; i < 4; i++) {
                int newX = nowX + dx[i];
                int newY = nowY + dy[i];
                
                if (newX < 0 || newX >= m || newY < 0 || newY >= n) {
                    continue;
                }
                
                if (!visit[newX][newY]) {
                    visit[newX][newY] = true;
                    q.offer(new int[]{newX, newY});
                }
            }
        }
        
        list.add(result);
        
    }
}
    
    
