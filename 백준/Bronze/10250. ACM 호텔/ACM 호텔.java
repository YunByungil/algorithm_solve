import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        // w개 방, h층
        int t = Integer.parseInt(br.readLine());
        for (int k = 0; k < t; k++) {
            st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            
            int answerH = 0;
            int answerW = 0;
            int count = 0;
            for (int i = 1; i <= w; i++) {
                for (int j = 1; j <= h; j++) {
                    count++;
                    // System.out.println("i = " + i + ", j = " + j);
                    if (count == n) {
                        // System.out.println("i = " + i + ", j = " + j);
                        answerH = j;
                        answerW = i;
                    }
                }
            }
            
            if (answerW < 10) {
                System.out.println(answerH + "0" + answerW);
            } else {
                System.out.println(answerH + "" + answerW);    
            }
        }
    }
}
