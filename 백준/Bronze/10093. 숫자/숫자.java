import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        
        if (a == b || b - a == 1 || a - b == 1) {
            System.out.println(0);
            return;
        }
        
        long size = (Math.abs(a - b)) - 1;
        System.out.println(size);
        
        if (b > a) {
            for (long i = a + 1; i < b; i++) {
                System.out.print(i + " ");
            }
        } else {
            for (long i = b + 1; i < a; i++) {
                System.out.print(i + " ");
            }
        }
    }
}
