import java.util.*;
import java.io.*;

public class Main {
    public static int n, k;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));        
        StringTokenizer st = null;
        
        String input = br.readLine();
        String[] arr = new String[input.length()];
        for (int i = 0; i < input.length(); i++) {
            String str = "";
            for (int j = i; j < input.length(); j++) {
                str += input.charAt(j);
            }
            arr[i] = str;
        }
        
        Arrays.sort(arr);
        
        for (String str : arr) {
            System.out.println(str);
        }
	}
}
    
    
