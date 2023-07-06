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
        Arrays.sort(arr);
        
        int result = arr[0];
        int answer = result;
        for (int i = 1; i < n; i++) {
            result += arr[i];
            answer += result;
        }
        
        System.out.println(answer);
        
    }
}
