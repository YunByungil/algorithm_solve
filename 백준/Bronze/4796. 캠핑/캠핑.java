import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int count = 1;        
        while (true) {
            st = new StringTokenizer(br.readLine());            
            int l = Integer.parseInt(st.nextToken()); // L일 동안만 사용
            int p = Integer.parseInt(st.nextToken()); // P일 중
            int v = Integer.parseInt(st.nextToken()); // V일짜리 휴가
            int answer = 0;
            if (l == 0 && p == 0 && v == 0) {
                break;
            }
            while (v > p) {
                v -= p;
                answer += l;
            }
            
            if (v > l) {
                answer += l;
            } else {
                answer += v;
            }
            System.out.println("Case " + count + ": " + answer);
            count++;
        }
    }
}
