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
        
        int resultM = 0;
        int m = 0;
        int mod = 0;
        for (int i : arr) {
            resultM = 0;
            resultM += i / 60;
            if (i % 60 != 0 || i % 60 == 0) {
                resultM++;
            } 
            m += (15 * resultM);
        }
        
        int resultY = 0;
        int y = 0;
        for (int i : arr) {
            resultY = 0;
            resultY += i / 30;
            if (i % 30 != 0 || i % 30 == 0) {
                resultY++;
            }
            
            y += (10 * resultY);
        }
        
        int answer = Math.min(y, m);
        if (y == m) {
            System.out.print("Y M " + answer);
        } else if (y > m) {
            System.out.print("M " + answer);
        } else if (y < m) {
            System.out.print("Y " + answer);
        }
        
    }
}
