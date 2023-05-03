import java.util.*;
import java.io.*;
public class Main {
    public static int n, m; // n: 세로 크기, m: 가로 크기
    public static int count; // 그림의 개수
    public static int max; // 가장 넓은 그림의 넓이
    public static int maxCount;
    public static int[] col = {1, -1, 0, 0};
    public static int[] row = {0, 0, 1, -1};
    public static int[][] arr; // 도화지
    public static boolean[][] visit;
    public static Queue<int[]> q = new LinkedList<>();
    
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        visit = new boolean[n][m];
        
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                String str = st.nextToken();
                arr[i][j] = Integer.parseInt(str);
            }
        }
        
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == 1 && !visit[i][j]) {
                    bfs(i, j);
                }
            }
        }
        
        System.out.println(count);
        System.out.println(max);
    }
    
    public static void bfs(int y, int x) {
        count++;
        maxCount = 1;
        q.offer(new int[]{y, x});
        visit[y][x] = true;
        while (!q.isEmpty()) {
            
            int[] nowLocation = q.poll();
            int nowX = nowLocation[1];
            int nowY = nowLocation[0];
            
            for (int i = 0; i < 4; i++) {
                int newX = nowX + col[i];
                int newY = nowY + row[i];
                
                if (newX < 0 || newX >= m || newY < 0 || newY >= n) {
                    continue;
                }
                
                if (!visit[newY][newX] && arr[newY][newX] == 1) {
                    maxCount++;
                    q.offer(new int[]{newY, newX});
                    visit[newY][newX] = true;
                }
            }
            
            max = Math.max(max, maxCount);
        }
        
    }
}