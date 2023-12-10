import java.util.*;
import java.io.*;

public class Main {
    // public static long a, b, c;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        st = new StringTokenizer(br.readLine());
        long a = Integer.parseInt(st.nextToken());
        long b = Integer.parseInt(st.nextToken());
        long c = Integer.parseInt(st.nextToken());
        
        long answer = pow(a, b, c);
        
        
        System.out.println(answer);
    }
    
    public static long pow(long a, long b, long c) {
        if (b == 1) {
            return a % c;
        }
        
        long value = pow(a, b / 2, c);
        value = value * value % c;
        
        if (b % 2 == 0) {
            return value;
        }
        
        return value * a % c;
    }
    
}
