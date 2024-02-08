import java.util.*;
import java.io.*;

public class Main {
    public static int n, k;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));        
        StringTokenizer st = null;
        
        int t = Integer.parseInt(br.readLine());
        
        for (int count = 0; count < t; count++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            
            int[] a = new int[n];
            int[] b = new int[m];
            
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }
            
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                b[i] = Integer.parseInt(st.nextToken());
            }
            
            Arrays.sort(a);
            Arrays.sort(b);
            int answer = 0;
            for (int i = n - 1; i >= 0; i--) {
                int valueA = a[i];
                // System.out.println("a = " + valueA);
                for (int j = m - 1; j >= 0; j--) {
                    int valueB = b[j];
                    // System.out.println("b = " + valueB);
                    if (valueA > valueB) {
                        // System.out.println("j ===============" + j);
                        answer += j + 1;
                        break;
                    }
                }
            }
            
            System.out.println(answer);
        }
        
	}
}
    
    
