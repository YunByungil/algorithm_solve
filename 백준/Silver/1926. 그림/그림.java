import java.util.*;
import java.io.*;


public class Main {
    public static int n, m;
    public static int[][] arr;
    public static Queue<int[]> q = new LinkedList<>();
    public static int answer;
    public static int[] dx = {0, 0, 1, -1};
    public static int[] dy = {1, -1, 0, 0};
    public static boolean[][] visit;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        
        st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        arr = new int[n][m];
        visit = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int count = 0;
        int a = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 1 && !visit[i][j]) {
                    visit[i][j] = true;
                    a = bfs(i, j);
                    count++;
                    answer = Math.max(answer, a);
                }
            }
        }
        
        System.out.println(count);
        System.out.println(answer);
        
        
    }
    
    public static int bfs(int x, int y) {
        int result = 1;
        q = new LinkedList<>();
        q.offer(new int[]{x, y});
        
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
                
                if (arr[newX][newY] == 1 && !visit[newX][newY]) {
                    visit[newX][newY] = true;
                    result++;
                    q.offer(new int[]{newX, newY});
                }
                
            }
        }
        
        return result;
        
    }
}