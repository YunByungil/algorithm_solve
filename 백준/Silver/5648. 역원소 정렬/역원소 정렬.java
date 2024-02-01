import java.util.*;
import java.io.*;

public class Main {
    public static int n;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = null;
        
        // n = Integer.praseInt(br.readLine());
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            sb = new StringBuilder();
            long num = sc.nextLong();
            sb.append(num);
            sb.reverse();
            
            arr[i] = Long.parseLong(sb.toString());
        }
        
        Arrays.sort(arr);
        
        for (long i : arr) {
            System.out.println(i);
        }
    }
}
    
    
