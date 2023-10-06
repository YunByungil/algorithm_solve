import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        String a = br.readLine();
        String b = br.readLine();
        
        System.out.println(Integer.parseInt(a) * (b.charAt(2) - '0'));
        System.out.println(Integer.parseInt(a) * (b.charAt(1) - '0'));
        System.out.println(Integer.parseInt(a) * (b.charAt(0) - '0'));
        System.out.println(Integer.parseInt(a) * Integer.parseInt(b));
        
        
        
        
    }
}
