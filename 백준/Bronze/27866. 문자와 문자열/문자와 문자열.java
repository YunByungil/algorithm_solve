import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        String s = br.readLine();
        int i = Integer.parseInt(br.readLine());
        
        System.out.println(s.charAt(i - 1));
    }
}
