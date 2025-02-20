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
            int mid = (a + b) / 2;

            int sum = a + b;
            if (sum % 2 != 0) {
                mid++;
            }
//             System.out.println(mid);
//             // int size = b - a;
//             // System.out.println("size = " + size);

            for (int j = a; j < mid; j++) {
                int tmp = arr[j];
                arr[j] = arr[b];
                arr[b] = tmp;

                b--;
            }
        }
        for (int i = 1; i <= 20; i++) {
            System.out.print(arr[i] + " ");
        }
        
    }
}
