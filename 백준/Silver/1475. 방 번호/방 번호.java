import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        // 한 세트는 0번부터 9번까지 숫자가 하나씩 들어있다.
        
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[10];
        
        while (n > 0) {
            arr[n % 10]++;
            n /= 10;
        }
        
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < 10; i++) {
            if (i == 6 || i == 9) {
                continue;
            }
            max = Math.max(max, arr[i]);
        }
        max = Math.max(max, (arr[6] + arr[9] + 1) / 2);
        
        System.out.println(max);
    }
}
