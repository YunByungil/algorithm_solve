// "static void main" must be defined in a public class.
import java.io.*;
import java.util.*;
public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // a를 b번 곱한 수 이를 c로 나눈 나머지를 구하는 프로그램
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long c = Long.parseLong(st.nextToken());
        
        System.out.println(func(a, b, c));
        
    }
    
    public static long func(long a, long b, long c) {
        if (b == 1) {
            return a % c;
        }
        
        long val = func(a, b / 2, c);
        // System.out.println(val);
        val = val * val % c;
        
         if (b % 2 == 0) {
             return val;
         }
        // System.out.println(val * a % c);
        return val * a % c;
    }
    
}