import java.util.*;
import java.io.*;

public class Main {
    public static int n, answer;
    public static int[] dx = {0, 0, -1, 1};
    public static int[] dy = {-1, 1, 0, 0};
    public static boolean[][] visit;
    public static int[][] arr;
    public static Queue<int[]> q = new LinkedList<>();
    public static List<Integer> list = new ArrayList<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        visit = new boolean[n][n];
        
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < input.length(); j++) {
                arr[i][j] = input.charAt(j) - '0';
            }
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visit[i][j] && arr[i][j] == 1) {
                    bfs(i, j);
                }
            }
        }
        
        Collections.sort(list);
        System.out.println(answer);
        for (int result : list) {
            System.out.println(result);
        }
    }
    
    public static void bfs(int x, int y) {
        int count = 1;
        q.offer(new int[]{x, y});
        visit[x][y] = true;
        answer++;
        
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
                
                if (!visit[newX][newY] && arr[newX][newY] == 1) {
                    q.offer(new int[]{newX, newY});
                    visit[newX][newY] = true;
                    count++;
                }
            }
        }
        
        list.add(count);
    }
}
