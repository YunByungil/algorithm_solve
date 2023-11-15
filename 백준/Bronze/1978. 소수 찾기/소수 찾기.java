import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        int n = Integer.parseInt(br.readLine());
        int answer = 0;
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            int count = 0;
            boolean isPrime = false;
            
            if (num == 1) {
                continue;
            }
            
            for (int j = 2; j <= num; j++) {
                if (num % j == 0) {
                    count++;
                }
                
            }
            
            if (count == 1) {
                answer++;
            }
        }        
        
        System.out.println(answer);
    }
}
