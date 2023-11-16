import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int size = 1_000_000;
        // int size = 20;
        int[] arr = new int[size + 1];
        for (int i = 2; i <= size; i++) {
            arr[i] = i;
        }
        
        for (int i = 2; i <= size; i++) {
            if (arr[i] == 0) {
                continue;
            }
            for (int j = i + i; j <= size; j += i) {
                arr[j] = 0;
            }
        }
        
        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        
        for (int i = m; i <= n; i++) {
            if (arr[i] != 0) {
                System.out.println(arr[i]);
            }
        }
    }
}
