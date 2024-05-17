import java.util.*;
import java.io.*;

public class Main {
    public static int n, m, k, t, w;
    public static int[] arr;
    public static boolean[] visit;
    // public static int[] dp;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));        
        StringTokenizer st = null;
        
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[k];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        visit = new boolean[101];
        int put = 0;
        int answer = 0;
        
        for (int i = 0; i < k; i++) {
            int tmp = arr[i];
            
            if (!visit[tmp]) {
                if (put < n) {
                    visit[tmp] = true;
                    put++;
                } else {
                    List<Integer> list = new ArrayList<>();
                    for (int j = i; j < k; j++) {
                        if (visit[arr[j]] && !list.contains(arr[j])) {
                            list.add(arr[j]);
                        }
                    }
                    
                    if (list.size() != n) {
                        for (int j = 0; j < visit.length; j++) {
                            if (visit[j] && !list.contains(j)) {
                                visit[j] = false;
                                break;
                            }
                        }
                    } else {
                        int remove = list.get(list.size() - 1);
                        visit[remove] = false;
                    }
                    
                    visit[tmp] = true;
                    answer++;
                }
            }
        }
        
        System.out.println(answer);
    }
}
    
    
