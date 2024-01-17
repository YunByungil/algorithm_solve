import java.util.*;
import java.io.*;

public class Main {
    public static int n, answer, count; // 계란의 수
    public static int[][] arr; // 계란 내구도, 무게
    public static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        // 계란1의 내구도 7, 무게5 - 계란2의 내구도3, 무게4
        // 계란 1로 계란 2를 치면 계란 1 내구도 4감소, 계란 2는 깨진다.

        n = Integer.parseInt(br.readLine());
        arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        dfs(0);
        System.out.println(answer);
    }

    public static void dfs (int depth) {
        if (depth == n) {
            answer = Math.max(answer, count);
            return;
        }
        
        if (count == n - 1 || arr[depth][0] <= 0) {
            dfs(depth + 1);
            return;
        }
        
        for (int i = 0; i < n; i++) {
            if (i == depth || arr[i][0] <= 0) {
                continue;
            }
            
            arr[depth][0] -= arr[i][1];
            arr[i][0] -= arr[depth][1];
            
            if (arr[depth][0] <= 0) count++;
            if (arr[i][0] <= 0) count++;
            dfs(depth + 1);
            
            if (arr[depth][0] <= 0) count--;
            if (arr[i][0] <= 0) count--;
            arr[depth][0] += arr[i][1];
            arr[i][0] += arr[depth][1];
            
        }

    }
}