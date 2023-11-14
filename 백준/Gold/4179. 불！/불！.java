import java.util.*;
import java.io.*;

public class Main {
    public static int r, c;
    public static int[] dx = {0, 0, 1, -1};
    public static int[] dy = {-1, 1, 0, 0};
    public static int[][] distance;
    public static String[][] arr;
    public static Queue<int[]> q = new LinkedList<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        distance = new int[r][c];
        arr = new String[r][c];
        
        for (int i = 0; i < r; i ++) {
            String input = br.readLine();
            for (int j = 0; j < input.length(); j++) {
                if (input.charAt(j) == 'F') {
                    q.offer(new int[]{i, j});
                }
                
                arr[i][j] = "" + input.charAt(j);
            }
        }
        
        for (int i = 0; i < r; i ++) {
            for (int j = 0; j < c; j++) {
                if (arr[i][j].equals("J")) {
                    q.offer(new int[]{i, j});
                }
                
            }
        }

        bfs();
        
//         for (int i = 0; i < r; i++) {
//             for (int j = 0; j < c; j++) {
//                 System.out.print(arr[i][j]);
//             }
//             System.out.println();
//         }
        
//         for (int i = 0; i < r; i++) {
//             for (int j = 0; j < c; j++) {
//                 System.out.print(distance[i][j]);
//             }
//             System.out.println();
//         }
        
        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < r; i++) {
            if (i == 0 || i == r - 1) {
                for (int j = 0; j < c; j++) {
                    if (arr[i][j].equals("J")) {
                        answer = Math.min(answer, distance[i][j]);
                    }
                }
            } else {
                if (arr[i][0].equals("J")) {
                    answer = Math.min(answer, distance[i][0]);
                } else if (arr[i][c - 1].equals("J")) {
                    answer = Math.min(answer, distance[i][c - 1]);
                }
            } 
        }
        
        if (answer == Integer.MAX_VALUE) {
            System.out.println("IMPOSSIBLE");
        } else {
            System.out.println(answer + 1);
        }
        
        // while (!q.isEmpty()) {
        //     int[] nowLocation = q.poll();
        //     System.out.println("x = " + nowLocation[0]);
        //     System.out.println("y = " + nowLocation[1]);
        // }
        
    }
    
    public static void bfs() {
        while (!q.isEmpty()) {
            int[] nowLocation = q.poll();
            int nowX = nowLocation[0];
            int nowY = nowLocation[1];
            
            for (int i = 0; i < 4; i++) {
                int newX = nowX + dx[i];
                int newY = nowY + dy[i];
                String str = arr[nowX][nowY];
                
                if (newX < 0 || newX >= r || newY < 0 || newY >= c) {
                    continue;
                }
                
                if (arr[newX][newY].equals(".")) {
                    q.offer(new int[]{newX, newY});
                    arr[newX][newY] = str;
                    distance[newX][newY] = distance[nowX][nowY] + 1;
                }
            }
        }
    }
}
