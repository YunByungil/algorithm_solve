import java.util.*;
import java.io.*;

public class Main {
    public static int n, m;
    public static int[] arr, temp;
    public static boolean[] visit;
    public static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        arr = new int[m];
        temp = new int[n];
        visit = new boolean[n];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            temp[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(temp);
        
        dfs(0, 0);
        System.out.println(sb);
    }
    
    public static void dfs(int depth, int start) {
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                sb.append(arr[i] + " ");
                // System.out.print(arr[i] + " ");
            }
            // System.out.println();
            sb.append("\n");
            
            return;
        }
        
        for (int i = start; i < n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                arr[depth] = temp[i];
                dfs(depth + 1, i);
                visit[i] = false;
            }
        }
    }
}
