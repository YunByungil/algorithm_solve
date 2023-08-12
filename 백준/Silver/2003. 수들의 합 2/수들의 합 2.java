import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        // Arrays.sort(arr);
        
        int sum = arr[0];
        int end = 0;
        int answer = 0;
        
        for (int start = 0; start < n; start++) {
            while (end < n && sum < m) {
                end++;
                if (end != n) {
                    sum += arr[end];
                }
            }
            
            if (end == n) {
                break;
            }
            
            if (sum == m) {
                answer++;
            }
            sum -= arr[start];
        }

        System.out.println(answer);
    }
}
