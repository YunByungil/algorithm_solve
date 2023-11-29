import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        StringBuilder sb = new StringBuilder();
        
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] answer = new int[2_000_001];
        
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        for (int i = 0; i < n; i++) {
                int num = arr[i];
                // System.out.println(num);
                answer[num + 1_000_000]++;
        }
        
        for (int i = 0; i < answer.length; i++) {
            if (answer[i] == 0) {
                continue;
            } else {
                while (answer[i]-- > 0) {
                    // System.out.println(i - 1_000_000);
                    sb.append(i - 1_000_000).append("\n");
                }
            }
        }
        System.out.println(sb);
        
    }
}
