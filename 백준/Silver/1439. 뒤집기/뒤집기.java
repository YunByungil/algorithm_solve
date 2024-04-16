import java.util.*;
import java.io.*;

public class Main {
    public static int n, m, k, t, w;
    public static int[] arr, tmp;
    public static int[] dp;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));        
        StringTokenizer st = null;
        
        String str = br.readLine();
        List<Integer> list = new ArrayList<>();
        list.add(str.charAt(0) - '0');
        int index = 0;
        
        for (int i = 1; i < str.length(); i++) {
            int num = str.charAt(i) - '0';
            if (num == list.get(index)) {
                continue;
            } else {
                index++;
                list.add(num);
            }
        }
        
        int zero = 0;
        int one = 0;
        for (Integer i : list) {
            if (i == 0) {
                zero++;
            } else {
                one++;
            }
        }
        
        int answer = Math.min(zero, one);
        System.out.println(answer);
    }
}
    
    
