import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        int[] arr = new int[9];
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }
        Arrays.sort(arr);
        boolean doing = true;
        int x = 0;
        int y = 0;
        for (int i = 0; i < 8; i++) {
            if (!doing) {
                break;
            }
            for (int j = i + 1; j < 9; j++) {
                sum -= (arr[i] + arr[j]);
                if (sum == 100) {
                    x = i;
                    y = j;
                    doing = false;
                    break;
                } else {
                    sum += (arr[i] + arr[j]);
                }
            }
        }
        
        for (int i = 0; i < 9; i++) {
            if (i == x || i == y) {
                continue;
            }
            System.out.println(arr[i]);
        }
    }
}
