import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[9];
        int sum = 0;
        int find = 0;
        for (int i = 0; i < 9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }
        
        Arrays.sort(arr);
        boolean doing = true;
        int x = 0;
        int y = 0;
        for (int i = 0; i < 8; i++) {
            int result = 0;
            if (!doing) {
                break;
            }
            for (int j = i + 1; j < 9; j++) {
                result = sum - (arr[i] + arr[j]);
                if (result == 100) {
                    doing = false;
                    x = i;
                    y = j;
                }
            }
        }
        
        // 7, 8, 10, 13, 15, 19, 20, 23, 25
        for (int i = 0; i < 9; i++) {
            if (i != x && i != y) {
                System.out.println(arr[i]);
            }
        }
    }
}