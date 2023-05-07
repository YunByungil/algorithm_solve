import java.util.*;
import java.io.*;

public class Main {
    public static int t; // 테스트 케이스 개수
    public static int l; // 체스판의 한 변의 길이, 체스판의 크기는 l * l
    public static int x, y; // 나이트의 좌표
    public static int ansX, ansY;
    
    public static int[][] arr; // 체스판
    public static int[][] result; // 이동거리
    public static boolean[][] visit; // 방문 여부
   
    public static int[] upCol = {2, 1, -1, -2};
    public static int[] upRow = {-1, -2, -2, -1};
    
    public static int[] downCol = {2, 1, -1, -2};
    public static int[] downRow = {1, 2, 2, 1};
   
    public static Queue<int[]> q = new LinkedList<>();
    
    
        
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        t = Integer.parseInt(br.readLine());
        
        
        for (int test = 0; test < t; test++) {
            l = Integer.parseInt(br.readLine());
            arr = new int[l][l];
            result = new int[l][l];
            visit = new boolean[l][l];
            
            StringTokenizer st = new StringTokenizer(br.readLine());
            y = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());
            bfs(y, x);
            st = new StringTokenizer(br.readLine());
            ansY = Integer.parseInt(st.nextToken());
            ansX = Integer.parseInt(st.nextToken());
            
            System.out.println(result[ansY][ansX]);
            
        }
        
    }
    
    public static void bfs(int y, int x) {
        q.offer(new int[]{y, x});
        visit[y][x] = true;
        
        while (!q.isEmpty()) {
            int[] nowLocation = q.poll();
            int nowY = nowLocation[0];
            int nowX = nowLocation[1];
            for (int i = 0; i < 4; i++) {
                
                int upY = nowY + upRow[i];
                int upX = nowX + upCol[i];
                if (upY < 0 || upY >= l || upX < 0 || upX >= l) {
                    continue;
                }
                
                if (!visit[upY][upX]) {
                    q.offer(new int[]{upY, upX});
                    visit[upY][upX] = true;
                    result[upY][upX] = result[nowY][nowX] + 1;
                }
                
            }
            
            for (int i = 0; i < 4; i++) {
                
                int downY = nowY + downRow[i];
                int downX = nowX + downCol[i];
                
                if (downY < 0 || downY >= l || downX < 0 || downX >= l) {
                    continue;
                }
                
                if (!visit[downY][downX]) {
                    q.offer(new int[]{downY, downX});
                    visit[downY][downX] = true;
                    result[downY][downX] = result[nowY][nowX] + 1;
                }
            }
        }
        
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
}