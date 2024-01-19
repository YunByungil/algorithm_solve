import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        
        int n = Integer.parseInt(br.readLine());
        
        int[] arr = new int[10_001];
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            arr[num]++;
        }
        
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] <= 0) continue;
            while (arr[i] > 0) {
                sb.append(i).append("\n");
                arr[i]--;
            }
        }
        
        System.out.println(sb);
    }
}
    
    
