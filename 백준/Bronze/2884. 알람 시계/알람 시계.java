import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int minute = m - 45;
        if (minute < 0) {
            if (h == 0) {
                h = 23;
            } else {
              h--;
            }
            
            minute = 60 + (m - 45);
        } 
        
        System.out.println(h + " " + minute);
        
    }
}
