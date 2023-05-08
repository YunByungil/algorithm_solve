import java.util.*;
import java.io.*;

public class Main {
    public static int r, c; // r: 미로 행의 개수, c: 열의 개수
    public static int answer = Integer.MAX_VALUE;
    public static String[][] arr;
    public static boolean[][] visit;
    public static int[][] result;
    public static int[] row = {-1, 1, 0, 0};
    public static int[] col = {0, 0, 1, -1};
    public static Queue<int[]> q = new LinkedList<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        arr = new String[r][c];
        visit = new boolean[r][c];
        result = new int[r][c];
        
        // for (int i = 0; i < r; i++) {
        //     String str = br.readLine();
        //     for (int j = 0; j < str.length(); j++) {
        //         arr[i][j] = String.valueOf(str.charAt(j));
        //         if (arr[i][j].equals("F") || arr[i][j].equals("J")) {
        //             q.offer(new int[]{i, j});
        //             visit[i][j] = true;
        //         }
        //     }
        // }
        
        for (int i = 0; i < r; i++) {
            String str = br.readLine();
            for (int j = 0; j < str.length(); j++) {
                arr[i][j] = String.valueOf(str.charAt(j));
                if (arr[i][j].equals("F")) {
                    q.offer(new int[]{i, j});
                    visit[i][j] = true;
                }
            }
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (arr[i][j].equals("J")) {
                    q.offer(new int[]{i, j});
                    result[i][j] = 1;
                    visit[i][j] = true;
                }
            }
        }
        
        bfs();
        
        // for (int i = 0; i < r; i++) {
        //     for (int j = 0; j < c; j++) {
        //         System.out.print(result[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        int check2 = -2;
        // i = 0, i = r - 1
        // i = 1, 2, 3, 4, 5, ... ,r - 2일 때는 j = 0, j = c - 1
        // 나머지는 전부
        for (int i = 0; i < r; i++) {
            if (i == 0 || i == r - 1) {
                for (int j = 0; j < c; j++) {
                    if (result[i][j] != 0) {
                        answer = Math.min(answer, result[i][j]);
                        check2 = 0;
                    }
                }
            }
            else {
                if (result[i][0] != 0 && result[i][c - 1] == 0) {
                    check2 = 0;
                    answer = Math.min(answer, result[i][0]);
                } else if (result[i][0] == 0 && result[i][c - 1] != 0) {
                    check2 = 0;
                    answer = Math.min(answer, result[i][c - 1]);
                } else if (result[i][0] != 0 && result[i][c - 1] != 0) {
                    check2 = 0;
                    int check = Math.min(result[i][c - 1], result[i][0]);
                    answer = Math.min(answer, check);
                }
            }
        }
        
        if (check2 == -2) {
            System.out.println("IMPOSSIBLE");    
        } else {
            System.out.println(answer);
        }
        
        
    }
    
    public static void bfs() {
        while (!q.isEmpty()) {
            int[] nowLocation = q.poll();
            int nowY = nowLocation[0];
            int nowX = nowLocation[1];

            for (int i = 0; i < 4; i++) {
                int newY = nowY + row[i];
                int newX = nowX + col[i];
                
                if (newY < 0 || newY >= r || newX < 0 || newX >= c) {
                    continue;
                }
                
                if (!visit[newY][newX] && arr[newY][newX].equals(".")
                   && arr[nowY][nowX].equals("F")) {
                    q.offer(new int[]{newY, newX});
                    visit[newY][newX] = true;
                    arr[newY][newX] = "F";
                }
                
                if (!visit[newY][newX] && arr[newY][newX].equals(".")
                   && arr[nowY][nowX].equals("J")) {
                    q.offer(new int[]{newY, newX});
                    visit[newY][newX] = true;
                    arr[newY][newX] = "J";
                    result[newY][newX] = result[nowY][nowX] + 1;
                    answer = result[newY][newX];
                }
            }
        }
    }
    
    
    
}