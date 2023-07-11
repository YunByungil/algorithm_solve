import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[1000001];
        int size = arr.length - 1;
        arr[0] = 0;
        arr[1] = 0;
        
        for (int i = 2; i <= size; i++) {
            arr[i] = i;
        }
        
        for (int i = 2; i <= size; i++) {
            for (int j = i + i; j <= size; j += i) {
                if (arr[j] == 0) {
                    continue;
                }
                arr[j] = 0;
            }
        }
        
        for (int i = m; i <= n; i++) {
            if (arr[i] != 0) {
                System.out.println(arr[i]);
            }
        }
        
    }
}
