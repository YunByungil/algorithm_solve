import java.util.*;
import java.io.*;

public class Main {
    public static int n, m, k, t, w;
    public static int[] arr, tmp;
    public static int[] dp;
    public static int answer;
    public static PriorityQueue<Integer> minus = new PriorityQueue<>();
    public static PriorityQueue<Integer> plus = new PriorityQueue<>(Comparator.reverseOrder());
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));        
        StringTokenizer st = null;
        
        n = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num <= 0) {
                minus.add(num);
            } else if (num == 1) {
                answer++;
            } else {
                plus.add(num);
            }
        }
        
        cal(minus);
        cal(plus);
        System.out.println(answer);
        
        
    }
    
    public static void cal(PriorityQueue<Integer> pq) {
        while (pq.size() > 1) {
            answer += (pq.poll() * pq.poll());
        }
        
        if (pq.size() == 1) {
            answer += pq.poll();
        }
    }
}
    
    
