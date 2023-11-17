import java.util.*;
import java.io.*;

public class Main {
    public static int n, answer, answer2;
    public static int[] dx = {0, 0, 1, -1};
    public static int[] dy = {-1, 1, 0, 0};
    public static boolean[][] visit;
    public static char[][] arr;
    public static char[][] arr2;
    public static Queue<int[]> q = new LinkedList<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        st = new StringTokenizer(br.readLine());
        int num1 = Integer.parseInt(st.nextToken());
        int num2 = Integer.parseInt(st.nextToken());
        
        System.out.println(gcd(num1, num2));
        System.out.println(lcm(num1, num2));
    }
    
    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
    
    public static int lcm(int a, int b) {
        return a * b / gcd(b, a % b);
    }
}
