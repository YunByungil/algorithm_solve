// "static void main" must be defined in a public class.
import java.io.*;
import java.util.*;

public class Main {
    public static int n;
    public static int[] arr;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        
        for (int i : arr) {
            System.out.println(i);
        }
    }
}