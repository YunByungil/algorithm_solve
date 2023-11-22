import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        while (true) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            
            if (a == 0 && b == 0 && c == 0) {
                break;
            }
            
            int aa = a * a;
            int bb = b * b;
            int cc = c * c;
            
            if (aa + bb == cc) {
                System.out.println("right");
            } else if (bb + cc == aa) {
                System.out.println("right");
            } else if (cc + aa == bb) {
                System.out.println("right");
            } else {
                System.out.println("wrong");
            }
        }
    }
}
