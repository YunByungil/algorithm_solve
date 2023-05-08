import java.util.*;
import java.io.*;

public class Main {
    public static int n; // 크기
    public static int answer, answer2; // 색맹이 아닌 사람, 색맹인 사람
    public static String color;
    public static int[] row = {-1, 1, 0, 0};
    public static int[] col = {0, 0, 1, -1};
    public static String[][] arr; 
    public static String[][] arr2;
    public static boolean[][] visit;
    public static boolean[][] visit2;
    public static Queue<int[]> q = new LinkedList<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        
        arr = new String[n][n];
        arr2 = new String[n][n];
        visit = new boolean[n][n];
        visit2 = new boolean[n][n];
        
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = String.valueOf(str.charAt(j));
                if (arr[i][j].equals("R") || arr[i][j].equals("G")) {
                    arr2[i][j] = "R";
                } else {
                    arr2[i][j] = "B";
                }
            }
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visit[i][j]) {
                    bfs(i, j, arr[i][j]);
                    
                }
                
                if (!visit2[i][j]) {
                    bfs2(i, j, arr2[i][j]);
                }
            }
        }
        
        System.out.print(answer + " " + answer2);
    }
    
    public static void bfs(int y, int x, String c) {
        color = c;

        answer++;
        q.offer(new int[]{y, x});
        visit[y][x] = true;
        
        while (!q.isEmpty()) {
            int[] nowLocation = q.poll();
            int nowY = nowLocation[0];
            int nowX = nowLocation[1];
            
            for (int i = 0; i < 4; i++) {
                int newY = nowY + row[i];
                int newX = nowX + col[i];
                
                if (newY < 0 || newY >= n || newX < 0 || newX >= n) {
                    continue;
                }
                
                if (!visit[newY][newX] && arr[newY][newX].equals(c)) {
                    q.offer(new int[]{newY, newX});
                    visit[newY][newX] = true;
                }
            }
        }
    }
    
    public static void bfs2(int y, int x, String c) {
        color = c;
        
        answer2++;
        q.offer(new int[]{y, x});
        visit[y][x] = true;
        
        while (!q.isEmpty()) {
            int[] nowLocation = q.poll();
            int nowY = nowLocation[0];
            int nowX = nowLocation[1];
            
            for (int i = 0; i < 4; i++) {
                int newY = nowY + row[i];
                int newX = nowX + col[i];
                
                if (newY < 0 || newY >= n || newX < 0 || newX >= n) {
                    continue;
                }
                
                if (!visit2[newY][newX] && arr2[newY][newX].equals(c)) {
                    q.offer(new int[]{newY, newX});
                    visit2[newY][newX] = true;
                }
            }
        }
    }
}