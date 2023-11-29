import java.util.*;
import java.io.*;

public class Main {
    public static int l, r, c;
    public static int[] dx = {0, 0, 0, 0, -1, 1};
    public static int[] dy = {0, 0, -1, 1, 0, 0};
    public static int[] dz = {-1, 1, 0, 0, 0, 0};
    public static boolean[][][] visit;
    public static char[][][] arr;
    public static int[][][] result;
    public static Queue<int[]> q = new LinkedList<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        while (true) {
            st = new StringTokenizer(br.readLine());
            l = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            q = new LinkedList<>();
            
            if (l == 0 && r == 0 && c == 0) {
                break;
            }
            
            arr = new char[l][r][c];
            result = new int[l][r][c];
            visit = new boolean[l][r][c];
            
            
            for (int i = 0; i < l; i++) {
                for (int j = 0; j < r + 1; j++) {
                    String str = br.readLine();
                    for (int k = 0; k < str.length(); k++) {
                        if (j == r) {
                            continue;
                        }
                        
                        char word = str.charAt(k);
                        if (word == 'S') {
                            visit[i][j][k] = true;
                            q.offer(new int[]{i, j, k});
                        }
                        if (word == '#') {
                            visit[i][j][k] = true;
                        }
                        
                        arr[i][j][k] = word;
                    }
                }
            }

            int answer = bfs();
            
            if (answer > 0) {
                System.out.println("Escaped in " + answer + " minute(s).");
            } else {
                System.out.println("Trapped!");
            }
            
            // for (int i = 0; i < l; i++) {
            //     for (int j = 0; j < r; j++) {
            //         for (int k = 0; k < c; k++) {
            //             System.out.print(result[i][j][k] + " ");
            //             // System.out.print(visit[i][j][k] + " ");
            //         }
            //         System.out.println();
            //     }
            //     System.out.println();
            // }
            // System.out.println();
        }
    }
    
    public static int bfs() {
        while (!q.isEmpty()) {
            int[] nowLocation = q.poll();
            int nowZ = nowLocation[0];
            int nowX = nowLocation[1];
            int nowY = nowLocation[2];
            
            for (int i = 0; i < 6; i++) {
                int newZ = nowZ + dz[i];
                int newX = nowX + dx[i];
                int newY = nowY + dy[i];
                
                if (newX < 0 || newX >= r 
                    || newY < 0 || newY >= c 
                    || newZ < 0 || newZ >= l) {
                    
                    continue;
                }
                
                if (arr[newZ][newX][newY] == 'E') {
                    // System.out.println(result[nowZ][nowX][nowY] + 1);
                    result[newZ][newX][newY] = result[nowZ][nowX][nowY] + 1;
                    return result[nowZ][nowX][nowY] + 1;
                }
                
                if (!visit[newZ][newX][newY] && arr[newZ][newX][newY] == '.') {
                    visit[newZ][newX][newY] = true;
                    q.offer(new int[]{newZ, newX, newY});
                    result[newZ][newX][newY] = result[nowZ][nowX][nowY] + 1;
                }
            }
        }
        
        return 0;
    }
}
