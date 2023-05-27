import java.util.*;
import java.io.*;

public class Main {
    public static int n, m; // n: 세로, m: 가로
    public static int nowDir;
    public static int result = 1;
    public static int[] dir; // 진행 방향
    public static int[] row = {1, -1, 0, 0};
    public static int[] col = {0, 0, 1, -1};
    public static int[][] arr;
    public static boolean[][] visit;
    public static Queue<int[]> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        visit = new boolean[n][m];
        
        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        nowDir = Integer.parseInt(st.nextToken());
        
        q.offer(new int[]{x, y});
        
        visit[x][y] = true;
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        arr[x][y] = 2;
        
        check();
        
        
        
        
        
        
        // for (int i = 0; i < n; i++) {
        //     for (int j = 0; j < m; j++) {
        //         System.out.print(arr[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        // System.out.println("=========");
        
        System.out.println(result);
        
        
    }
    // 1. 내 현 위치에서 4칸을 조사 후 빈칸이 있는지 체크
    public static void check() {
        while (!q.isEmpty()) {
            boolean game = true;
            int[] nowLocation = q.poll();
            
            int nowX = nowLocation[0];
            int nowY = nowLocation[1];
            
            for (int i = 0; i < 4; i++) {
                int newX = nowX + row[i];
                int newY = nowY + col[i];
                
                if (newX < 0 || newX >= n || newY < 0 || newY >= m) {
                    continue;
                }
                
                // if (visit[newX][newY]) {
                //     continue;
                // }
                
                if (arr[newX][newY] == 0) {
                    move(nowX, nowY);
                    result++;
                    game = false;
                    break;
                }
            }
            
            if (game) {
                back(nowX, nowY);
            }
        }
    }
    
    public static void move(int x, int y) {
        for (int i = 0; i < 4; i++) {
            if (nowDir == 0) { // 현재 북쪽, 회전 -> 서쪽
                if (arr[x][y -1] == 0) {
                    arr[x][y - 1] = 2;
                    // arr[x][y - 1] = arr[x][y] + 1;
                    q.offer(new int[]{x, y - 1});
                    nowDir = 3;
                    return;
                } else {
                    nowDir = 3;
                }
            } else if (nowDir == 1) { // 현재 동쪽, 회전 -> 북쪽
                if (arr[x - 1][y] == 0) {
                    arr[x - 1][y] = 2;
                    // arr[x - 1][y] = arr[x][y] + 1;
                    q.offer(new int[]{x - 1, y});
                    nowDir = 0;
                    return;
                } else {
                    nowDir = 0;
                }
            } else if (nowDir == 2) { // 현재 남쪽, 회전 -> 동쪽
                if (arr[x][y + 1] == 0) {
                    arr[x][y + 1] = 2;
                    // arr[x][y + 1] = arr[x][y] + 1;
                    q.offer(new int[]{x, y + 1});
                    nowDir = 1;
                    return;
                } else {
                    nowDir = 1;
                }
            } else if (nowDir == 3) { // 현재 서쪽, 회전 -> 남쪽
                if (arr[x + 1][y] == 0) {
                    arr[x + 1][y] = 2;
                    // arr[x + 1][y] = arr[x][y] + 1;
                    q.offer(new int[]{x + 1, y});
                    nowDir = 2;
                    return;
                } else {
                    nowDir = 2;
                }
            }
        }
    }
    
    public static void back(int x, int y) {
        if (nowDir == 0) {
            if (arr[x + 1][y] == 2) {
                q.offer(new int[]{x + 1, y});
            }
        } else if (nowDir == 1) {
            if (arr[x][y - 1] == 2) {
                q.offer(new int[]{x, y - 1});
            }
        } else if (nowDir == 2) {
            if (arr[x - 1][y] == 2) {
                q.offer(new int[]{x - 1, y});
            }
        } else if (nowDir == 3) {
            if (arr[x][y + 1] == 2) {
                q.offer(new int[]{x, y + 1});
            }
        }
        
    }
}