import java.util.*;
import java.io.*;

public class Main {
    public static int n, m, k, t, w, answer;
    public static int f, s, g, u, d;
    public static int[] dx = {0, 0, -1, 1};
    public static int[] dy = {-1, 1, 0, 0};
    // public static int[] dx = {1, 2, 1, 2, -1, -2, -1, -2};
    // public static int[] dy = {-2, -1, 2, 1, -2, -1, 2, 1};
    public static int[][] arr;
    public static int[][] map;
    public static boolean[][] visit;
    // public static int[] arr;
    // public static boolean[] visit;
    public static Queue<int[]> q = new LinkedList<>();
    // public static Queue<Integer> q = new LinkedList<>();
    // public static List<Integer> list = new ArrayList<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));        
        StringTokenizer st = null;

        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        visit = new boolean[n][n];
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int answer = 0;
        for (int k = 0; k <= 100; k++) {
            visit = new boolean[n][n];
            int count = 0;
            rain(k);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visit[i][j]) {
                        count++;
                        bfs(i, j);
                    }
                }
            }
            answer = Math.max(answer, count);
        }
        System.out.println(answer);
        
    }
    
    public static int bfs(int x, int y) {
        int count = 0;
        q.offer(new int[]{x, y});
        visit[x][y] = true;
        
        while (!q.isEmpty()) {
            count++;
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
                    visit[newX][newY] = true;
                    q.offer(new int[]{newX, newY});
                }
            }
        }
        
        return count;
    }
    
    public static void rain(int num) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] <= num) {
                    visit[i][j] = true;
                }
            }
        }
        
    }
}
    
    
