import java.util.*;
import java.io.*;

public class Main {
    public static int n, r, c, answer;
    
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        
        int newN = (int) Math.pow(2.0, n);
        
        
        answer = dfs(n, r, c);
        System.out.println(answer);
    }
    
    public static int dfs(int n, int r, int c) {
        if (n == 0) {
            return 0;
        }
        
        int half = 1 << (n - 1);
        
        if (r < half && c < half) {
            return dfs(n - 1, r, c);
        } else if (r < half && c >= half) {
            return half * half + dfs(n - 1, r, c - half);
        } else if (r >= half && c < half) {
            return 2 * half * half + dfs(n - 1, r - half, c);
        } else {
            return 3 * half * half + dfs(n - 1, r - half, c - half);
        }
    }
}
