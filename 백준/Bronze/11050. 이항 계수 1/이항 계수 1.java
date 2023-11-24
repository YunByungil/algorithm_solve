import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        System.out.println(factorial(n) / (factorial(n - k) * factorial(k)));
    }
    
    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        }
        
        return n * factorial(n - 1);
    }
}
