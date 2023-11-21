import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        double[] result = new double[n];
        
        st = new StringTokenizer(br.readLine());
        double max = 0;
        for (int i = 0; i < n; i++) {
            int score = Integer.parseInt(st.nextToken());
            arr[i] = score;
            max = Math.max(max, score);
        }
        
        for (int i = 0; i < n; i++) {
            result[i] = (arr[i] / max) * 100;
        }
        
        double answer = 0;
        for (double i : result) {
            answer += i;
        }
        
        System.out.println(answer / n);
        
    }
}
