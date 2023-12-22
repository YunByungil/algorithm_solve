import java.util.*;
import java.io.*;

public class Main {
    public static int n, white, blue;
    public static int[][] arr;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        dfs(n, 0, 0);
        System.out.println(white);
        System.out.println(blue);
        
        
    }
    
    public static void dfs(int size, int x, int y) {
        if (check(size, x, y)) {
            int num = arr[x][y];
            
            if (num == 1) {
                blue++;
            } else {
                white++;
            }
            
            return;
        } 
        
        if (size == 0) {
            return;
        }
        
        int half = size / 2;
        dfs(half, x, y);
        dfs(half, x, y + half);
        
        dfs(half, x + half, y);
        dfs(half, x + half, y + half);
        
    }
    
    public static boolean check(int size, int x, int y) {
        int color = arr[x][y];
        
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (arr[i][j] != color) {
                    return false;
                }
            }
        }
        
        return true;
    }
}
