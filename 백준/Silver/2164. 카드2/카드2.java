import java.util.*;
import java.io.*;
public class Main {
    public static int n; // n장의 카드 
    public static LinkedList<Integer> q = new LinkedList<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        
        
        for (int i = 1; i <= n; i++) {
            q.offer(i);
        }
        
        while (q.size() > 1) {
            // 1. 제일 위에 있는 카드를 바닥에 버린다.
            
            q.poll();
            
            // 2. 맨 위에 카드를 맨 뒤로 옮긴다.
            q.offer(q.poll());
        }
        
        System.out.println(q.poll());
        
    }
}