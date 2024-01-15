import java.util.*;
import java.io.*;

public class Main {
    public static int l, c;
    public static String[] arr, answer;
    public static boolean[] visit;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        st = new StringTokenizer(br.readLine());
        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        answer = new String[l];
        arr = new String[c];
        visit = new boolean[c];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < c; i++) {
            String input = st.nextToken();
            arr[i] = input;
        }
        Arrays.sort(arr);
        
        dfs(0, 0);
        
        
    }
    
    public static void dfs(int depth, int start) {
        if (depth == l) {
            boolean result = false;
            int count = 0;
            for (int i = 0; i < l; i++) {
                if (answer[i].equals("a") ||
                   answer[i].equals("e") ||
                   answer[i].equals("i") ||
                   answer[i].equals("o") ||
                   answer[i].equals("u")) {
                    result = true;
                } else {
                    count++;
                }
                
                // System.out.print(answer[i] + " ");
            }
            
            if (result && count >= 2) {
                for (int i = 0; i < l; i++) {
                    System.out.print(answer[i]);
                }
                
                System.out.println();
            }
            return;
        }
        
        for (int i = start; i < c; i++) {
            if (!visit[i]) {
                visit[i] = true;
                answer[depth] = arr[i];
                dfs(depth + 1, i + 1);
                visit[i] = false;
            }
        }
    }
}    
