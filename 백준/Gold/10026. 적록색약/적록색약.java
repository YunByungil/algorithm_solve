import java.util.*;
import java.io.*;

public class Main {
    public static int n, m, k, t, w, answer;
    public static int[] dx = {0, 0, -1, 1};
    public static int[] dy = {-1, 1, 0, 0};
    public static char[][] arr;
    public static char[][] arr2;
    public static boolean[][] visit;
    public static Queue<int[]> q = new LinkedList<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));        
        StringTokenizer st = null;
        
        n = Integer.parseInt(br.readLine());
        arr = new char[n][n];
        arr2 = new char[n][n];
        visit = new boolean[n][n];
        
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < input.length(); j++) {
                char ch = input.charAt(j);
                arr[i][j] = ch;
                if (ch == 'G') {
                    arr2[i][j] = 'R';
                } else {
                    arr2[i][j] = ch;
                }
            }
        }
        
        

        int answer = 0;
        for (int i = 0; i < n; i++) {
           for (int j = 0; j < n; j++) {
                if (!visit[i][j]) {
                    answer++;
                    visit[i][j] = true;
                    bfs(i, j, arr[i][j], arr);
                }
            }
        }
        System.out.print(answer + " ");
        
        answer = 0;
        visit = new boolean[n][n];
        for (int i = 0; i < n; i++) {
           for (int j = 0; j < n; j++) {
                if (!visit[i][j]) {
                    visit[i][j] = true;
                    answer++;
                    bfs(i, j, arr2[i][j], arr2);
                }
            }
        }
        
        System.out.println(answer);
    }
    
    public static void bfs(int x, int y, char color, char[][] arr) {
        q.offer(new int[]{x, y});
        
        while(!q.isEmpty()) {
            int[] nowLocation = q.poll();
            int nowX = nowLocation[0];
            int nowY = nowLocation[1];
            
            for (int i = 0; i < 4; i++) {
                int newX = nowX + dx[i];
                int newY = nowY + dy[i];
                
                if (newX < 0 || newX >= n || newY < 0 || newY >= n) {
                    continue;
                }
                
                if (!visit[newX][newY] && color == arr[newX][newY]) {
                    visit[newX][newY] = true;
                    q.offer(new int[]{newX, newY});
                }
            }
        }
    }
}
    
    
