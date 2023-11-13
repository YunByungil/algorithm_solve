import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        st = new StringTokenizer(br.readLine());

        int[] arr = new int[8];
        for (int i = 0; i < 8; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
        }

        String answer = "";
        for (int i : arr) {
            answer += String.valueOf(i);
        }
        
        if (answer.equals("87654321")) {
            System.out.println("descending");
        } else if (answer.equals("12345678")) {
            System.out.println("ascending");
        } else {
            System.out.println("mixed");
        }
    }
}
