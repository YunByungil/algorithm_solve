import java.util.*;
import java.io.*;

public class Main {
    public static int t; // 테스트 케이스 개수
    public static int m, n, k; // 가로 길이, 세로 길이, 배추가 심어져 있는 위치의 개수
    public static int x, y; // 배추의 위치 x: 가로, y: 세로
    public static int answer; // 지렁이 마리 수
    public static int[] col = {0, 0, 1, -1};
    public static int[] row = {1, -1, 0, 0};
    public static int[][] arr; // 배추밭
    public static boolean[][] visit; // 방문 여부
    public static Queue<int[]> q = new LinkedList<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        t = Integer.parseInt(br.readLine());
        
        for (int test = 0; test < t; test++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            answer = 0;
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            
            arr = new int[n][m];
            visit = new boolean[n][m];
            
            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                x = Integer.parseInt(st.nextToken());
                y = Integer.parseInt(st.nextToken());
                
                arr[y][x] = 1;
            }
            
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (arr[i][j] == 1 && !visit[i][j]) {
                        bfs(i, j);
                    }
                }
            }
            System.out.println(answer);
        }
    }
    
    public static void bfs(int y, int x) {
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
                
                if (newY < 0 || newY >= n || newX < 0 || newX >= m) {
                    continue;
                }
                
                if (!visit[newY][newX] && arr[newY][newX] == 1) {
                    q.offer(new int[]{newY, newX});
                    visit[newY][newX] = true;
                    
                }
            }
        }
    }
}