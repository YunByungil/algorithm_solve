// "static void main" must be defined in a public class.
import java.util.*;
import java.io.*;

public class Main {
    public static int n;
    public static int[][] arr;
    public static int minus, zero, one;
    
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        StringTokenizer st = null;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0, 0, n);
        System.out.println(minus);
        System.out.println(zero);
        System.out.println(one);
        
    }
    
    public static void dfs(int y, int x, int n) {
        if (check(y, x, n)) {
            if (arr[y][x] == 0) {
                zero++;
            } else if (arr[y][x] == 1) {
                one++;
            } else if (arr[y][x] == -1) {
                minus++;
            }
            
            return;
        }
        
        int half = n / 3;
        dfs(y, x, half);
        dfs(y, x + half, half);
        dfs(y, x + half + half, half);
        
        dfs(y + half, x, half);
        dfs(y + half, x + half, half);
        dfs(y + half, x + half + half, half);
        
        dfs(y + half + half, x, half);
        dfs(y + half + half, x + half, half);
        dfs(y + half + half, x + half + half, half);
        
        
        
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