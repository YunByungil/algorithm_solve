import java.util.*;
import java.io.*;

public class Main {
    public static int n;
    public static char[][] arr;
    public static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        

        String a = st.nextToken();
        String b = st.nextToken();
        
        String reverseA = "";
        String reverseB = "";
        
        for (int i = a.length() - 1; i >= 0; i--) {
            reverseA += a.charAt(i) - '0';
        }
        
        for (int i = b.length() - 1; i >= 0; i--) {
            reverseB += b.charAt(i) - '0';
        }
        
        if (Integer.parseInt(reverseA) > Integer.parseInt(reverseB)) {
            System.out.println(reverseA);
        } else {
            System.out.println(reverseB);
        }
        
    }
}
