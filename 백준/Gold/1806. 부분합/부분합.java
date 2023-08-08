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
        int length = 0;
        int answer = Integer.MAX_VALUE;
        int num = arr[0];
        int end = 0;
        
        for (int start = 0; start < n; start++) {
            while (end < n && num < m) {
                end++;
                if (end != n) {
                    num += arr[end];
                }
            }
            if (end == n) {
                break;
            }

            answer = Math.min(answer, (end - start) + 1);
            
            num -= arr[start];
        }
        
        if (answer == Integer.MAX_VALUE) {
            System.out.println(0);
        } else {
            System.out.println(answer);
        }
    }
}