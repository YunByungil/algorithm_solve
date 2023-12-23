import java.util.*;
import java.io.*;

public class Main {
    public static int n, black, white;
    public static int[][] arr;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < str.length(); j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }
        
        dfs(n, 0, 0);
        
    }
    
    public static void dfs(int n, int x, int y) {
        if (check(n, x, y)) {
            System.out.print(arr[x][y]);
            return;
        }
        
        int size = n / 2;
        System.out.print("(");
        dfs(size, x, y);
        dfs(size, x, y + size);
        
        dfs(size, x + size, y);
        dfs(size, x + size, y + size);
        System.out.print(")");
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
