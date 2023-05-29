import java.util.*;
import java.io.*;

public class Main {
    public static int n, k; // n: 보드 크기, k: 사과의 개수
    public static int tail, head, size; // tail: 꼬리 위치, head: 머리 위치, size: 뱀 크기
    public static int result = 0;
    public static int tailX;
    public static int tailY;
    public static int now;
    public static int[][] arr; // 보드
    public static int[][] apple;
    public static int[] dir;
    public static boolean[][] visit;
    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {1, 0, -1, 0};
    public static Queue<int[]> q = new LinkedList<>();
    public static int tailIndex;
    public static List<Integer> newTailX = new ArrayList<>();
    public static List<Integer> newTailY = new ArrayList<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        
        arr = new int[n][n];
        visit = new boolean[n][n];
        apple = new int[n][n];
        dir = new int[10001];
        
        visit[0][0] = true;
        q.offer(new int[]{0, 0});
        tail = 0; // size 까지 필요 x
        head = 0;
        size = 1;
        now = 0;
        newTailX.add(0);
        newTailY.add(0);
        
        
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            apple[x][y] = 1;
        }
        
        int l = Integer.parseInt(br.readLine());
        
        
        for (int i = 0; i < l; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            String y = st.nextToken();
            
            if (y.equals("D")) {
                dir[x] = 1;
            } else {
                dir[x] = -1;
            }
        }
        
        dfs();
        System.out.println(result);
        
    }
    
    public static void dfs() {
        while (!q.isEmpty()) {
            int[] location = q.poll();
            int nowX = location[0];
            int nowY = location[1];
            
            
            checkDir();
            int newX = nowX + dx[now];
            int newY = nowY + dy[now];
            
            
            if (newX < 0 || newX >= n || newY < 0 || newY >= n) { // 게임 종료
                result++;
                return;
            }
            
            if (visit[newX][newY]) {
                result++;
                return;
            }
            
            newTailX.add(newX);
            newTailY.add(newY);
            
            if (apple[newX][newY] == 1) {
                
                q.offer(new int[]{newX, newY});
                visit[newX][newY] = true;
                apple[newX][newY] = 0;
            } else {
                q.offer(new int[]{newX, newY});
                visit[newX][newY] = true;
                visit[newTailX.get(tailIndex)][newTailY.get(tailIndex)] = false;
                tailIndex++;                
            }
            
            result++;
        }
    }
    
    public static void checkDir() {
        
        int check = dir[result];
        now = now + check;        
        
        if (now == 4) {
            now = 0;
        } else if (now == -1) {
            now = 3;
        }
    }
    
    
    
    
    
    
    
    
}