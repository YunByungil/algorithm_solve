// "static void main" must be defined in a public class.
import java.util.*;
import java.io.*;

public class Main {
    public static int[][] arr;
    public static int[] dir;
    public static int k; // 회전 횟수, 방향
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new int[4][8];
        
        for (int i = 0; i < 4; i++) {
            String str = br.readLine();
            for (int j = 0; j < 8; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }

        // 1. 톱니를 먼저 회전하자. 1 -> 시계방향, -1 -> 반시계 방향
        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken()) - 1;
            int turn = Integer.parseInt(st.nextToken());
            
            dir = new int[4];
            
            dir[num] = turn;
            checkDir(num);
            gearTurn();
        }
        int answer = 0;
        for (int i = 0; i < 4; i++) {
            if (arr[i][0] == 1) {
                answer += 1 << i;
            }
        }
        // if (arr[0][0] == 1) {
        //     answer += 1;
        // } 
        // if (arr[1][0] == 1) {
        //     answer += 2;
        // } 
        // if (arr[2][0] == 1) {
        //     answer += 4;
        // } 
        // if (arr[3][0] == 1) {
        //     answer += 8;
        // }
        System.out.println(answer);
    }
    
    public static void checkDir(int num) {
        for (int i = num - 1; i >= 0; i--) {
            if (arr[i][2] != arr[i + 1][6]) {
                dir[i] = -dir[i + 1];
            } else {
                break;
            }
        }
        
        for (int i = num + 1; i < 4; i++) {
            if (arr[i][6] != arr[i - 1][2]) {
                dir[i] = -dir[i - 1];
            } else {
                break;
            }
        }
    }
    
    public static void gearTurn() {
        int temp = 0;
        
        for (int i = 0; i < 4; i++) {
            if (dir[i] == 1) {
                temp = arr[i][7];
                for (int j = 7; j > 0; j--) {
                    arr[i][j] = arr[i][j - 1];
                }
                arr[i][0] = temp;
            } else if (dir[i] == -1) {
                temp = arr[i][0];
                for (int j = 0; j < 7; j++) {
                    arr[i][j] = arr[i][j + 1];
                }
                arr[i][7] = temp;
            }
        }
    }
    
    
    
}