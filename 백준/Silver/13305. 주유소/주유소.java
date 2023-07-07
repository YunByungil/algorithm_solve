import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        int n = Integer.parseInt(br.readLine());
        int[] money = new int[n];
        int[] dis = new int[n - 1];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < dis.length; i++) {
            dis[i] = Integer.parseInt(st.nextToken());
        }
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < money.length; i++) {
            money[i] = Integer.parseInt(st.nextToken());
        }
        
        int result = money[0] * dis[0];
        int index = money[0];
        for (int i = 1; i < dis.length; i++) {
            index = Math.min(index, money[i]);
            result += index * dis[i];
        }
        
        System.out.println(result);
    }
}
