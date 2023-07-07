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
        
        int result = 0;
        int index = 0;
        for (int i = 0; i < dis.length; i++) {
            if (money[i] > money[i + 1]) {
                result += money[index] * dis[i];
                index++;
            }  else {
                result += money[index] * dis[i];
            }
        }
        
        System.out.println(result);
    }
}
