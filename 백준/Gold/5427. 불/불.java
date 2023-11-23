import java.util.*;
import java.io.*;

public class Main {
    public static int t, w, h;
    public static int[] dx = {0, 0, -1, 1};
    public static int[] dy = {-1, 1, 0, 0};
    public static boolean[][] visit;
    public static char[][] arr;
    public static int[][] distance;
    public static Queue<int[]> q = new LinkedList<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        t = Integer.parseInt(br.readLine());
        
        for (int count = 0; count < t; count++) {
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            visit = new boolean[h][w];
            arr = new char[h][w];
            distance = new int[h][w];
            
            for (int i = 0; i < h; i++) {
                String input = br.readLine();
                for (int j = 0; j < w; j++) {
                    arr[i][j] = input.charAt(j);
                }
            }
            
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (arr[i][j] == '*') {
                        q.offer(new int[]{i, j});
                    }
                }
            }
            
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (arr[i][j] == '@') {
                        q.offer(new int[]{i, j});
                    }       
                }
            }
            
            bfs();
            
//             for (int i = 0; i < h; i++) {
//                 for (int j = 0; j < w; j++) {
//                     System.out.print(distance[i][j]);       
//                     System.out.print(arr[i][j]);
//                 }
//                 System.out.println();
//             }
            
//             System.out.println();
            
            int answer = Integer.MAX_VALUE;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (i == 0 || i == h - 1) {
                        if (arr[i][j] == '@') {
                            answer = Math.min(answer, distance[i][j]);
                        }
                    } else {
                        if (j == 0 || j == w - 1) {
                            if (arr[i][j] == '@') {
                                answer = Math.min(answer, distance[i][j]);
                            }
                        }
                    }
                }
            }
            
            if (answer == Integer.MAX_VALUE) {
                System.out.println("IMPOSSIBLE");
            } else {
                System.out.println(answer + 1);
            }
            
        }
    }
    
    public static void bfs() {
        while (!q.isEmpty()) {
            int[] nowLocation = q.poll();
            int nowX = nowLocation[0];
            int nowY = nowLocation[1];
                
            for (int i = 0; i < 4; i++) {
                int newX = nowX + dx[i];
                int newY = nowY + dy[i];
                
                if (newX < 0 || newX >= h || newY < 0 || newY >= w) {
                    continue;
                }
                
                
                if (!visit[newX][newY] && arr[newX][newY] == '.') {
                    arr[newX][newY] = arr[nowX][nowY];
                    visit[newX][newY] = true;
                    q.offer(new int[]{newX, newY});
                    distance[newX][newY] = distance[nowX][nowY] + 1;
                }
            }
        }
    }
}
