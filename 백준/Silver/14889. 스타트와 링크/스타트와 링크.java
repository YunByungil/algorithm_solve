import java.util.*;
import java.io.*;

public class Main {
    public static int n;
    public static int start;
    public static int link;
    public static int min = Integer.MAX_VALUE;
    public static int[][] arr;
    public static boolean[] visit;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        visit = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0, 0);
        System.out.println(min);
        
    }
    
    public static void dfs(int now, int depth) {
        if (depth == n / 2) {
            getStart();
            getLink();
            min = Math.min(min, Math.abs(start - link));
            return;
        }
        
        for (int i = now; i < n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                dfs(i + 1, depth + 1);
                visit[i] = false;
            }
        }
    }
    
    public static void getStart() {
        start = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (visit[i] && visit[j]) {
                    start += (arr[i][j] + arr[j][i]);
                }
            }
        }
    }
    
    public static void getLink() {
        link = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (!visit[i] && !visit[j]) {
                    link += arr[i][j];
                    link += arr[j][i];
                }
            }
        }
        
    }
}