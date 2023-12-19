import java.util.*;
import java.io.*;

public class Main {
    public static int n, m;
    public static int[] arr;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = i;
        }
        
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            int temp = arr[a];
            arr[a] = arr[b];
            arr[b] = temp;
        }
        
        for (int i = 1; i <= n; i++) {
            System.out.print(arr[i] + " ");
        }
        
    }
}
