import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        
        int answer = 0;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 1; j <= arr[i]; j++) {
                if (arr[i] % j == 0) {
                    count++;
                }
            }
            
            if (count == 2) {
                answer++;
            }
        }
        System.out.println(answer);
        
    }
    
}