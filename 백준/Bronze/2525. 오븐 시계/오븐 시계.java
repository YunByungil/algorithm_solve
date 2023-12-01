import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(br.readLine());
        
        int minute = (a * 60) + b + c;

        int h = minute / 60;
        int min = minute % 60;
        if (h >= 24) {
            h = h - 24;
        }
        System.out.print(h + " " + min);
        
    }
}
