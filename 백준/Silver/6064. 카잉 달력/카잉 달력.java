import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        int t = Integer.parseInt(br.readLine());
        for (int count = 0; count < t; count ++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;

            boolean check = false;
            
            for (int i = x; i < (m * n); i += m) {
                if (i % n == y) {
                    check = true;
                    System.out.println(i + 1);
                    break;
                }
            }
            
            if (!check) {
                System.out.println(-1);
            }
        }
    }
}