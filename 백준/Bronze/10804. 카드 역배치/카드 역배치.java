import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        int[] arr = new int[21];
        for (int i = 1; i <= 20; i++) {
            arr[i] = i;
        }
        
        for (int i = 0; i < 10; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int mid = (b - a) / 2;
            for (int j = 0; j <= mid; j++) {
                int temp = arr[a + j];
                arr[a + j] = arr[b - j];
                arr[b - j] = temp;
            }
        }

        for (int i = 1; i <= 20; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
