import java.util.*;
import java.io.*;

public class Main {
    public static int n;
    public static int[] arr;
    public static int[] cal;
    public static int max = Integer.MIN_VALUE;
    public static int min = Integer.MAX_VALUE;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        cal = new int[4];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            cal[i] = Integer.parseInt(st.nextToken());
        }
        
        dfs(arr[0], 1);
        System.out.println(max);
        System.out.println(min);
        
    }
    
    public static void dfs(int sum, int depth) {
        if (depth == n) {
            max = Math.max(max, sum);
            min = Math.min(min, sum);
            return;
        }
        
        for (int i = 0; i < 4; i++) {
            if (cal[i] > 0) {
                cal[i]--;
                if (i == 0) {
                    dfs(sum + arr[depth], depth + 1);
                } else if (i == 1) {
                    dfs(sum - arr[depth], depth + 1);
                } else if (i == 2) {
                    dfs(sum * arr[depth], depth + 1);
                } else if (i == 3) {
                    dfs(sum / arr[depth], depth + 1);
                }
                
                cal[i]++;
            }
            
        }
    }     
}