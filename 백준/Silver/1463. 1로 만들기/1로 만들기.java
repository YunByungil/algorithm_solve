import java.util.*;
import java.io.*;

public class Main {
    public static int n;
    public static int[] arr;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));        
        StringTokenizer st = null;
        
        int n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        // arr[1] = 1;
        
        for (int i = 2; i <= n; i++) {
            
            if (i % 3 == 0) {
                arr[i] = Math.min(arr[i - 1] + 1, arr[i / 3] + 1);
            } else if (i % 2 == 0) {
                arr[i] = Math.min(arr[i - 1] + 1, arr[i / 2] + 1);
            } else {
                arr[i] = arr[i - 1] + 1;
            }
            
            if (i % 6 == 0) {
                arr[i] = Math.min(Math.min(arr[i / 2], arr[i / 3]), arr[i - 1]) + 1;
            }
        }
        
        // for (int i = 1; i <= n; i++) {
        //     System.out.println("arr[" + i + "] = " + arr[i]);
        // }
        System.out.println(arr[n]);
	}
}
    
    
