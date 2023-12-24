import java.util.*;
import java.io.*;

public class Main {
    public static int n;
    public static char[][] arr;
    public static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        n = Integer.parseInt(br.readLine());
        arr = new char[n][n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = ' ';
            }
        }
        
        dfs(n, 0, 0);

        
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(arr[i][j]);
            }
            sb.append("\n");
        }
        
        System.out.println(sb);
        
    }
    
    public static void dfs(int n, int x, int y) {
        if (n == 1) {
            arr[x][y] = '*';
            return;
        }
        
        int size = n / 3;
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 1 && j == 1) {
                    continue;
                }
                dfs(size, x + size * i, y + size * j);
            }
        }
    }
}
