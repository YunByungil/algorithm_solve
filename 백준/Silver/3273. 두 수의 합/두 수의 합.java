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
        
        int x = Integer.parseInt(br.readLine());
        int answer = 0;
        Arrays.sort(arr);
        int start = 0;
        int end = n - 1;
        
        while (start < end) {
            if (arr[start] + arr[end] == x) {
                end--;
                answer++;
            }
            
            if (arr[start] + arr[end] < x) {
                start++;
            }
            
            if (arr[start] + arr[end] > x) {
                end--;
            }
        }
        
        System.out.println(answer);
    }
}
