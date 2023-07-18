import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int count = 0; count < t; count++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            
            long answer = 0;
            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    answer += dfs(arr[i], arr[j]);
                }
            }
            sb.append(answer).append("\n");
        }
        
        System.out.println(sb);
    }
    
    public static int dfs(int a, int b) {
        if (b == 0) {
            return a;
        }
        
        return dfs(b, a % b);
    }
}
