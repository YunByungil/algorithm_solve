// "static void main" must be defined in a public class.
import java.util.*;
import java.io.*;

public class Main {
    public static int k;
    public static int[] arr, result;
    public static boolean[] visit;
    public static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            arr = new int[k];
            result = new int[6];
            visit = new boolean[k];
            if (k == 0) {
                break;
            }
            
            for (int i = 0; i < k; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            
            dfs(0, 0);
            sb.append("\n");
        }        
        
        System.out.println(sb);
    }
    
    public static void dfs(int depth, int start) {
        if (depth == 6) {
            for (int i = 0; i < 6; i++) {
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        
        for (int i = start; i < k; i++) {
            if (!visit[i]) {
                visit[i] = true;
                result[depth] = arr[i];
                dfs(depth + 1, i);
                visit[i] = false;
            }
        }
    }
}