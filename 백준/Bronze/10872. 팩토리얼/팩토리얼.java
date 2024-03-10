import java.util.*;
import java.io.*;

public class Main {
    public static int n, k, t, w;
    public static int[] arr, tmp;
    public static int[] dp;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));        
        StringTokenizer st = null;
        
        n = Integer.parseInt(br.readLine());
        
        int answer = 1;
        for (int i = 1; i <= n; i++) {
            answer *= i;
        }
        
        System.out.println(answer);
        
    }
}
    
    
