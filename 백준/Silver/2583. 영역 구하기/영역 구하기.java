import java.util.*;
import java.io.*;

public class Main {
    public static int m, n, k, answer, wide; // m: 세로, n: 가로, k: 분리된 영역
    public static int[] dx = {0, 0, -1, 1};
    public static int[] dy = {-1, 1, 0, 0};
    public static boolean[][] visit;
    public static int[][] arr;
    public static Queue<int[]> q = new LinkedList<>();
    public static List<Integer> list = new ArrayList<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        
        arr = new int[m][n];
        visit = new boolean[m][n];
        
        for (int count = 0; count < k; count++) {
            st = new StringTokenizer(br.readLine());
            
            int startX = Integer.parseInt(st.nextToken());
            int startY = m - Integer.parseInt(st.nextToken());
            
            int endX = Integer.parseInt(st.nextToken());
            int endY = m - Integer.parseInt(st.nextToken());
            
            for (int i = endY; i < startY; i++) {
                for (int j = startX; j < endX; j ++) {
                    visit[i][j] = true;
                    arr[i][j] = 1;
                }
            }
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visit[i][j]) {
                    wide = 1;
                    answer++;
                    bfs(i, j);
                    list.add(wide);
                }
            }
        }
        
        System.out.println(answer);
        
        Collections.sort(list);
        for (int l : list) {
            System.out.print(l + " ");
        }
        
    }
    
    public static void bfs(int x, int y) {
        q.offer(new int[]{x, y});
        visit[x][y] = true;
        
        
        while (!q.isEmpty()) {
            int[] nowLocation = q.poll();
            int nowX = nowLocation[0];
            int nowY = nowLocation[1];
            
            for (int i = 0; i < 4; i++) {
                int newX = nowX + dx[i];
                int newY = nowY + dy[i];
                
                if (newX < 0 || newX >= m || newY < 0 || newY >= n) {
                    continue;
                }
                
                if (arr[newX][newY] == 0 && !visit[newX][newY]) {
                    visit[newX][newY] = true;
                    wide++;
                    q.offer(new int[]{newX, newY});
                }
            }
        }
    }
}
