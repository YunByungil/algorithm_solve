// "static void main" must be defined in a public class.
import java.util.*;
import java.io.*;

public class Main {
    public static int n; // 영상의 크기
    public static int[][] arr;
    public static int zero; // 흰 점
    public static int one; // 검은 점
    public static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        
        arr = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }
        
        // for (int i = 0; i < n; i++) {
        //     for (int j = 0; j < n; j++) {
        //         System.out.print(arr[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        
        dfs(0, 0, n);
        
    }

    public static void dfs(int y, int x, int n) {
        
        zero = 0;
        one = 0;
        
        if (check(y, x, n)) {
            
            if (arr[y][x] == 0) {
                zero++;
            } else {
                one++;
            }
            if (one > 0) {
                
                System.out.print("1");
            }
            if (zero > 0) {
                System.out.print("0");
            }
            return;
        }
        int half = n / 2;
        System.out.print("(");
        dfs(y, x, half);
        dfs(y, x + half, half);
        dfs(y + half, x, half);
        dfs(y + half, x + half, half);
        System.out.print(")");
        
        
    }
    
    public static boolean check(int y, int x, int size) {
        int color = arr[y][x];
        
        for (int i = y; i < y + size; i++) {
            for (int j = x; j < x + size; j++) {
                if (arr[i][j] != color) {
                    return false;
                }
            }
        }
        return true;
    }
    
}