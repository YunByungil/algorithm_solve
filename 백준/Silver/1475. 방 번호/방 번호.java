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
            int num = n % 10;
            if (n % 10 == 6) {
                arr[9]++;
            } else {
                arr[n % 10]++;    
            }
            n /= 10;
        }
        
        int max = Integer.MIN_VALUE;
        if (arr[9] % 2 == 0) {
            arr[9] = arr[9] / 2;
        } else {
            arr[9] = arr[9] / 2 + 1;
        }
        
        for (int i : arr) {
            if (i > 0) {
                max = Math.max(max, i);
            }
        }
        
        System.out.println(max);
    }
}
