import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            arr[i] = i;
        }
        
        int count = 0;
        for (int i = 2; i <= n; i++) {
            for (int j = i; j <= n; j += i) {
                if (arr[j] <= 0) continue;
                count++;
                arr[j] = 0;
                if (count == k) {
                    System.out.println(j);
                    return;
                }
            }
        }
    }
}
    
    
