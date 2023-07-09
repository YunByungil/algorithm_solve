import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        
        int t = Integer.parseInt(br.readLine());
        for (int count = 0; count < t; count++) {
            int n = Integer.parseInt(br.readLine());
            int max = 0;
            long money = 0;
            int buy = 0;
            int[] arr = new int[n];
            // 1. 구매 2. 원하는 만큼 판매 3. 아무것도 안 한다
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            
            for (int i = n - 1; i >= 0; i--) {
                if (max < arr[i]) {
                    max = arr[i];
                }
                
                if (max > arr[i]) {
                    money += (max - arr[i]);
                }
            }
            
            System.out.println(money);
        }
        
    }
    
}
