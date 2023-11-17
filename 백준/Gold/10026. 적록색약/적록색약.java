import java.util.*;
import java.io.*;

public class Main {
    public static int n, answer, answer2;
    public static int[] dx = {0, 0, 1, -1};
    public static int[] dy = {-1, 1, 0, 0};
    public static boolean[][] visit;
    public static char[][] arr;
    public static char[][] arr2;
    public static Queue<int[]> q = new LinkedList<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        n = Integer.parseInt(br.readLine());
        visit = new boolean[n][n];
        arr = new char[n][n];
        arr2 = new char[n][n];
        
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < input.length(); j++) {
                char color = input.charAt(j);
                arr[i][j] = color;
                arr2[i][j] = color;
                if (color == 'G') {
                    arr2[i][j] = 'R';
                }
            }
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visit[i][j]) {
                    answer++;
                    bfs(i, j, arr);
                }
            }
        }
        
        visit = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visit[i][j]) {
                    answer2++;
                    bfs(i, j, arr2);
                }
            }
        }
        
        System.out.println(answer + " " + answer2);
        
        
    }
    
    public static void bfs(int x, int y, char[][] arr) {
        visit[x][y] = true;
        q.offer(new int[]{x, y});
        
        while (!q.isEmpty()) {
            int[] nowLocation = q.poll();
            int nowX = nowLocation[0];
            int nowY = nowLocation[1];
            char nowColor = arr[x][y];
            
            for (int i = 0; i < 4; i++) {
                int newX = nowX + dx[i];
                int newY = nowY + dy[i];
                
                if (newX < 0 || newX >= n || newY < 0 || newY >= n) {
                    continue;
                }
                
                if (!visit[newX][newY] && arr[newX][newY] == nowColor) {
                    visit[newX][newY] = true;
                    q.offer(new int[]{newX, newY});
                }
            }
        }
    }
}
