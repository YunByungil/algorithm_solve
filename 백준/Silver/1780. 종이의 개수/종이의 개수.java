import java.util.*;
import java.io.*;

public class Main {
    public static int n;
    public static int result1, result2, result3;
    public static int[][] arr;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());
                arr[i][j] = num;
            }
        }
        
        
        dfs(n, 0, 0);
        System.out.println(result1 + "\n" + result2 + "\n" + result3);
        
    }
    
    public static void dfs(int n, int x, int y) {
        if (check(n, x, y)) {
            int result = arr[x][y];
            if (result == -1) {
                result1++;
            } else if (result == 0) {
                result2++;
            } else {
                result3++;
            }
            
            return;
        }
        
        int size = n / 3;
        
        dfs(size, x, y);
        dfs(size, x, y + size);
        dfs(size, x, y + 2 * size);
        
        dfs(size, x + size, y);
        dfs(size, x + size, y + size);
        dfs(size, x + size, y + 2 * size);
        
        dfs(size, x + 2 * size, y);
        dfs(size, x + 2 * size, y + size);
        dfs(size, x + 2 * size, y + 2 * size);
    }
    
    
    public static boolean check(int size, int x, int y) {
        int now = arr[x][y];
        
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (arr[i][j] != now) {
                    return false;
                }
            }
        }
        
        return true;
    }
}
