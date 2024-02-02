import java.util.*;
import java.io.*;

public class Main {
    public static int n, c;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        // st = new StringTokenizer(br.readLine());
        // n = Integer.parseInt(st.nextToken());
        // c = Integer.praseInt(st.nextToken());
        n = Integer.parseInt(br.readLine());
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }
        
        Arrays.sort(arr);
        
        int count = 0;
        int maxCount = 0;
        long answer = 0;
        for (int i = 0; i < n; i++) {
            if (i == 0 || arr[i - 1] == arr[i]) {
                count++;
                continue;
            } else {
                if (count > maxCount) {
                    answer = arr[i - 1];
                    maxCount = count;
                }
                count = 1;
            }
        }
        
        if (count > maxCount) {
            answer = arr[n - 1];
        }
        
        System.out.println(answer);
        
        
    }
}
    
    
