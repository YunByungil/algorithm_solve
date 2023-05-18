// "static void main" must be defined in a public class.
import java.io.*;

public class Main {
        
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        
        int[] arr = new int[n];
        int[] count = new int[20000001];
        
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            count[num + 1000000]++;
        }
        
        for (int i = count.length - 1; i >= 0; i--) {
            while (count[i] > 0) {
                sb.append(i - 1000000).append("\n");
                count[i]--;
            }
        }
        System.out.println(sb);
    }
}