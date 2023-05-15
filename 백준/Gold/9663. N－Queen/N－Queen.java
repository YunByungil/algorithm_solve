// "static void main" must be defined in a public class.
import java.util.*;
import java.io.*;

public class Main {
    public static int n;
    public static int answer;
    public static int[] arr;
    public static boolean[] visit;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        
        arr = new int[n];
        visit = new boolean[n];
        
        dfs(0);
        System.out.println(answer);
        
    }
    
    public static void dfs(int depth) {
        if (depth == n) {
            answer++;
            return;
        }
        
        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                arr[depth] = i + 1;
                if (check(depth)) {
                    dfs(depth + 1);
                }
                visit[i] = false;
            }
                
        }
    }
    
    public static boolean check(int depth) {
        for (int i = 0; i < depth; i++) {
            if (arr[depth] == arr[i]) {
                return false;
            }
        }
        
        for (int i = 0; i < depth; i++) {
            if (Math.abs(depth - i) == Math.abs(arr[depth] - arr[i])) {
                // System.out.println("대각 : " + arr[i]);
                return false;
            }
        }
        
        return true;
    }
}