import java.util.*;
import java.io.*;

public class Main {
    public static int n, m, t, k;
    public static int[] arr, tmp;
    public static boolean[][] dp;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));        
        StringTokenizer st = null;
        
        int answer = 0;  
        for (int i = 1; i <= 5; i++) {
            answer += Integer.parseInt(br.readLine());
        }
        System.out.print(answer);        
    }
}
    
    
