import java.util.*;
import java.io.*;

public class Main {
    public static int n, m;
    public static int[] arr;
    public static boolean[] visit;
    public static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        arr = new int[m];
        visit = new boolean[n];
        
        dfs(0);
        System.out.println(sb);
    }
    
    public static void dfs(int depth) {
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                // System.out.print(arr[i] + " ");
                sb.append(arr[i]).append(" ");
            }
            // System.out.println();
            sb.append("\n");
            
            return;
        }
        
        for (int i = 0; i < n; i++) {
            arr[depth] = i + 1;
            dfs(depth + 1);
        }
    }
}
