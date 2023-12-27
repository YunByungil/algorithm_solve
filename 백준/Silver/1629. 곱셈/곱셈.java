import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long c = Long.parseLong(st.nextToken());
        
        
        System.out.println(dfs(a, b, c));
    }
    
    public static long dfs(long a, long b, long c) {
        if (b == 1) {
            return a % c;
        }
        
        long value = dfs(a, b / 2, c);
        value = value * value % c;
        
        if (b % 2 == 0) {
            return value;
        } else {
            return value * a % c;
        }
        
        
        
    }
}
