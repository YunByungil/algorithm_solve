import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        int[] arr = new int[123_456 * 2 + 1];
        int num = arr.length - 1;
        arr[1] = 0;
        for (int i = 2; i <= num; i++) {
            arr[i] = i;
        }
        for (int i = 2; i <= num; i++) {
            for (int j = i + i; j <= num; j += i) {
                if (arr[j] == 0) {
                    continue;
                }
                arr[j] = 0;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                break;
            }
            int count = 0;
            for (int i = n + 1; i <= 2 * n; i++) {
                if (arr[i] != 0) {
                    count++;
                }
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
        
    }
}