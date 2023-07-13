import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        int num = 1;
        for (int i = 1; i <= n; i++) {
            num *= i;
        }
        int num2 = 1;
        int num3 = 1;
        for (int i = 1; i <= k; i++) {
            num2 *= i;
        }
        for (int i = 1; i <= n - k; i++) {
            num3 *= i;
        }
        
        int answer = num / (num2 * num3);
        System.out.println(answer);
    }
}
