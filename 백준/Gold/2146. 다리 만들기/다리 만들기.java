import java.util.*;
import java.io.*;

public class Main {
    public static int n, m;
    public static int landNum = 2;
    public static int answer = Integer.MAX_VALUE;
    public static int[] dx = {0, 0, -1, 1};
    public static int[] dy = {-1, 1, 0, 0};
    public static boolean[][] visit;
    public static int[][] arr, dis;
    public static Queue<int[]> q = new LinkedList<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        dis = new int[n][n];
        visit = new boolean[n][n];
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());
                arr[i][j] = num;
            }
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visit[i][j] && arr[i][j] == 1) {
                    setMap(i, j);
                }
            }
        }
        
        visit = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visit[i][j] && arr[i][j] != 0) {
                    int result = bfs(i, j);
                    dis = new int[n][n];
                    visit = new boolean[n][n];
                    q = new LinkedList<>();
                    answer = Math.min(result, answer);
                    // print();
                }
            }
        }
        
        System.out.println(answer);
        
    }
    
    public static void print() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(dis[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    public static int bfs(int x,int y) {
        q.offer(new int[]{x, y});
        int nowLandNum = arr[x][y];
        visit[x][y] = true;
        
        while (!q.isEmpty()) {
            int[] nowLocation = q.poll();
            int nowX = nowLocation[0];
            int nowY = nowLocation[1];
            
            for (int i = 0; i < 4; i++) {
                int newX = nowX + dx[i];
                int newY = nowY + dy[i];
                
                if (newX < 0 || newX >= n || newY < 0 || newY >= n) {
                    continue;
                }
                
                if (arr[newX][newY] == nowLandNum) {
                    visit[newX][newY] = true;
                    continue;
                }
                
                if (arr[newX][newY] != 0 && arr[newX][newY] != nowLandNum) {
                    return dis[nowX][nowY];
                }
                
                if (!visit[newX][newY] && arr[newX][newY] == 0) {
                    q.offer(new int[]{newX, newY});
                    visit[newX][newY] = true;
                    dis[newX][newY] = dis[nowX][nowY] + 1;
                }
            }
        }
        
        return Integer.MAX_VALUE;
    }
    
    public static void setMap(int x, int y) {
        arr[x][y] = landNum;
        q.offer(new int[]{x, y});
        visit[x][y] = true;
        
        while (!q.isEmpty()) {
            int[] nowLocation = q.poll();
            int nowX = nowLocation[0];
            int nowY = nowLocation[1];
            
            for (int i = 0; i < 4; i++) {
                int newX = nowX + dx[i];
                int newY = nowY + dy[i];
                
                if (newX < 0 || newX >= n || newY < 0 || newY >= n) {
                    continue;
                }
                
                if (!visit[newX][newY] && arr[newX][newY] != 0) {
                    q.offer(new int[]{newX, newY});
                    visit[newX][newY] = true;
                    arr[newX][newY] = landNum;
                }
            }
        }
        
        landNum++;
    }
}
