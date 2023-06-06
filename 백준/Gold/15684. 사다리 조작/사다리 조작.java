import java.util.*;
import java.io.*;

public class Main {
    public static int n, m, h;
    public static int result = 4;
    public static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        arr = new int[h + 1][n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a][b] = 1;
        }
        
        // for (int i = 1; i <= h; i++) {
        //     for (int j = 1; j <= n; j++) {
        //         System.out.print(arr[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        dfs(0, 1, 1);
        if (result == 4) {
            result = -1;
        }
        System.out.println(result);
    }
    
    public static void dfs(int depth, int y, int x) {
        if (depth >= result) {
            return;
        }
        if (check()) {
            result = depth;
            return;
        }
        
        if (depth == 3) {
            return;
        }
        
        for (int i = y; i <= h; i++) {
            for (int j = x; j < n; j++) {
                if (arr[i][j] == 0 && arr[i][j - 1] == 0 && arr[i][j + 1] == 0) {
                    arr[i][j] = 1;
                    dfs(depth + 1, i, j);
                    arr[i][j] = 0;
                }
            }
            x = 1;
        }
    }
    
    public static boolean check() {
        
        for (int i = 1; i <= n; i++) {
            int pos = i;
            
            for (int j = 0; j <= h; j++) {
                if (arr[j][pos] == 1) {
                    pos++;
                } else if (arr[j][pos - 1] == 1) {
                    pos--;
                }
            }
            
            if (pos != i) {
                return false;
            }
        }
        
        return true;
    }
}
