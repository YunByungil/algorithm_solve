import java.util.*;
import java.io.*;

public class Main {
    public static int n, t;
    public static int[] arr, dp;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));        
        StringTokenizer st = null;
        
        t = Integer.parseInt(br.readLine());
        for (int count = 0; count < t; count++) {
            arr = new int[11];
            
            n = Integer.parseInt(br.readLine());
            arr[1] = 1;
            arr[2] = 2;
            arr[3] = 4;
            
            for (int i = 4; i <= n; i++) {
                arr[i] = arr[i - 1] + arr[i - 2] + arr[i - 3];
            }
            
            System.out.println(arr[n]);
        }
        
        
	}
}
    
    
