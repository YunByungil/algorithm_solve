import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        while (true) {
            String str = br.readLine();
            if (str == null || str.isEmpty()) {
                break;
            }
            System.out.println(str);
        }
        
    }
}
