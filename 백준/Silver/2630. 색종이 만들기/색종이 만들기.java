// "static void main" must be defined in a public class.
import java.util.*;
import java.io.*;

public class Main {
    public static int n; // 종이의 크기
    public static int one;
    public static int zero;
    public static int[][] arr; // 색종이 배열
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        
        
        StringTokenizer st = null;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        func(0, 0, n);
        System.out.println(zero);
        System.out.println(one);
    }
    
    public static void func(int y, int x, int n) {
        if (checkColor(y, x, n)) {
            if (arr[y][x] == 0) {
                zero++;
            } else {
                one++;
            }
            return;
        }
        
        int half = n / 2;
        func(y, x, half); // 제 2사분면
        func(y, x + half, half); // 제 1사분면
        func(y + half, x, half); // 제 3사분면
        func(y + half, x + half, half); // 제 4사분면
        
    }
    
    public static boolean checkColor(int y, int x, int size) {
        int color = arr[y][x]; // 
        for (int i = y; i < y + size; i++) {
            for (int j = x; j < x + size; j++) {
                if (arr[i][j] != color) {
                    return false;
                }
            }
        }
        return true;
    }
}