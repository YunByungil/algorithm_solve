// "static void main" must be defined in a public class.
import java.util.*;
import java.io.*;

public class Main {
    public static int n, m; // 1부터 n까지 자연수 중 중복 없이 m개를 고른 수열
    public static int[] arr;
    public static boolean[] visit;
    public static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        arr = new int[m];
        visit = new boolean[n];
        
        dfs(0, 0);
        System.out.println(sb);
    }
    
    public static void dfs(int depth, int start) {
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        
        for (int i = start; i < n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                arr[depth] = i + 1;
                dfs(depth + 1, i);
                visit[i] = false;
            }
        }
    }
}