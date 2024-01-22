import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        StringBuilder sb = new StringBuilder();
        
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[2_000_001];
        
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            arr[num + 1_000_000]++;
        }
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= 0) continue;
            while (arr[i] > 0) {
                // System.out.println(i - 1_000_000);
                sb.append(i - 1_000_000).append("\n");
                arr[i]--;
            }
        }
        
        System.out.println(sb);
        
    }
}
    
    
