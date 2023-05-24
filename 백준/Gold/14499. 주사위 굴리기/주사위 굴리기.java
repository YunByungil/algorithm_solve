// "static void main" must be defined in a public class.
import java.io.*;
import java.util.*;

public class Main {
    public static int n, m, k; // n: 세로, m: 가로, k: 움직이는 횟수
    public static int x, y; // 주사위를 놓을 좌표
    public static int index;
    public static int ceil;
    public static int[][] arr;
    public static int[] dice; // 바닥: 0, 앞: 4, 천장:5, 왼쪽 옆:3, 오른쪽 옆: 2 뒤: 1
    /* 주사위 모양
        1
      3 0 2
        4
        5
    */
    
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        dice = new int[6];
        
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int point = Integer.parseInt(st.nextToken());
                arr[i][j] = point;
            }
        }
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            int dir = Integer.parseInt(st.nextToken());
            if (dir == 1) { // 동쪽으로 이동
                if (y + 1 >= m) {
                    continue;
                }
                y++;
                moveEast();
                change();
                System.out.println(dice[3]);
            } else if (dir == 2) { // 서쪽으로 이동
                if (y - 1 < 0) {
                    continue;
                }
                y--;
                moveWest();
                change();
                System.out.println(dice[3]);
            } else if (dir == 3) { // 북쪽으로 이동
                if (x - 1 < 0) {
                    continue;
                }
                x--;
                moveNorth();
                change();
                System.out.println(dice[3]);
            } else if (dir == 4) { // 남쪽으로 이동
                if (x + 1 >= n) {
                    continue;
                }
                x++;
                moveSouth();
                change();
                System.out.println(dice[3]);
            }
        }
        
        // for (int i = 0; i < n; i++) {
        //     for (int j = 0; j < m; j++) {
        //         System.out.print(arr[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        
    }
    
    public static void moveSouth() {
        int temp = dice[0];
        for (int i = 1; i < 4; i++) {
            dice[i - 1] = dice[i];
        }
        
        dice[3] = temp;
    }
    
    public static void moveNorth() {
        int temp = dice[3];
        for (int i = 3; i > 0; i--) {
            dice[i] = dice[i - 1];
        }
        
        dice[0] = temp;
    }
    
    public static void moveEast() {
        int temp = dice[1];
        dice[1] = dice[5];
        dice[5] = dice[3];
        dice[3] = dice[4];
        dice[4] = temp;
    }
    
    public static void moveWest() {
        int temp = dice[1];
        dice[1] = dice[4];
        dice[4] = dice[3];
        dice[3] = dice[5];
        dice[5] = temp;
    }
    
    public static void change() {
        if (arr[x][y] == 0) {
            arr[x][y] = dice[1];
        } else if (arr[x][y] != 0) {
            dice[1] = arr[x][y];
            arr[x][y] = 0;
        }
    }
    
    
}