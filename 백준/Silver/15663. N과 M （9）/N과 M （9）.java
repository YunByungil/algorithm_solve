import java.util.*;
import java.io.*;

public class Main {
    public static int n, m;
    public static Set<String> set = new LinkedHashSet<>();
    public static int[] arr, temp;
    public static boolean[] visit;
    public static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        arr = new int[m];
        temp = new int[n];
        visit = new boolean[n];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            temp[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(temp);
        
        dfs(0);
        List<String> list = new ArrayList<>(set);
        
        for (String str : list) {
            System.out.print(str);
        }
    }
    
    public static void dfs(int depth) {
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                sb.append(arr[i] + " ");
                // System.out.print(arr[i] + " ");
            }
            // System.out.println();
            sb.append("\n");
            
            set.add(sb.toString());
            // System.out.println("result = " + result);
            sb = new StringBuilder();
            return;
        }
        
        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                arr[depth] = temp[i];
                dfs(depth + 1);
                visit[i] = false;
            }
        }
    }
}
