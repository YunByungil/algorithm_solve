import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = 9;
        int max = 0;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            arr[i] = num;
            max += num;
        }
        
        Arrays.sort(arr);
        int fake1 = 0;
        int fake2 = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (max - arr[i] - arr[j] == 100) {
                    fake1 = arr[i];
                    fake2 = arr[j];
                }
            }
        }
        
        for (int i = 0; i < n; i++) {
            if (arr[i] == fake1 || arr[i] == fake2) {
                continue;
            }
            System.out.println(arr[i]);
        }

        
        
    }
}
    
    
