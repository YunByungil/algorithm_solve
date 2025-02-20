import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        // 영식 요금제: 30초마다 10원씩 청구
        // 민식 요금제: 60초마다 15원씩 청구
        // 어느 요금제를 사용하는 것이 저렴한지 출력하는 프로그램
        
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        // 영식
        int y = 0;
        for (int i = 0; i < n; i++) {
            int num = arr[i] / 30;
            num += 1;            
            y += num * 10;
        }

        // 민식
        int m = 0;
        for (int i = 0; i < n; i++) {
            int num = arr[i] / 60;
            num += 1;
            m += num * 15;
        }

        if (y < m) {
            System.out.print("Y ");
            System.out.print(y);
        } else if (y > m) {
            System.out.print("M ");
            System.out.print(m);
        } else {
            System.out.print("Y M " + y);
        }
        
    }
}
