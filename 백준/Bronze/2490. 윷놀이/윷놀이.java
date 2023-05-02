import java.util.*;
import java.io.*;
public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            
            int answer = a + b + c + d;
            if (answer == 0) {
                System.out.println("D");
            } else if (answer == 1) {
                System.out.println("C");
            } else if (answer == 2) {
                System.out.println("B");
            } else if (answer == 3) {
                System.out.println("A");
            } else if (answer == 4) {
                System.out.println("E");
            }
        }
    }
}