// "static void main" must be defined in a public class.
import java.io.*;
import java.util.*;

public class Main {
    public static int n;
    public static int[] arr;
    public static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        
        arr = new int[2000001];
        for (int i = 0; i < n; i++) {
            arr[Integer.parseInt(br.readLine()) + 1000000]++;
        }
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                sb.append(i - 1000000).append("\n");
            }
        }
        
        System.out.println(sb);
    }
}