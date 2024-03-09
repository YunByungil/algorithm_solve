import java.util.*;
import java.io.*;

public class Main {
    public static int n, k, t, w;
    public static int[] arr, tmp;
    public static int[] dp;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));        
        StringTokenizer st = null;
        
        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        dp = new int[n + 1];
        tmp = new int[n + 1];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        dp[0] = 1;
        
        for (int i = 1; i <= n; i++) {
            dp[i] = 1;
            for (int j = 1; j < i; j++) {
                if (arr[i] > arr[j]) {
                    if (dp[i] <= dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                        tmp[i] = j;
                    }
                }
            }
        }
        
        
        int answer = 0;
        int index = 0;
        for (int i = 1; i <= n; i++) {
            if (answer < dp[i]) {
                answer = dp[i];
                index = i;
            }
        }
        
        System.out.println(answer);
        int result = index;
        List<Integer> list = new ArrayList<>();
        
        // for (int i : tmp) {
        //     System.out.println("i = " + i);
        // }
        
        while (result > 0) {
            list.add(arr[result]);
            result = tmp[result];
        }
        
        Collections.sort(list);
        for (int i : list) {
            System.out.print(i + " ");
        }
    }
}
    
    
