import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        Queue<Integer> q = new LinkedList<>();
        int n = Integer.parseInt(br.readLine());
        
        for (int i = 1; i <= n; i++) {
            q.offer(i);
        }
        
        while (q.size() > 1) {
            q.poll();
            q.offer(q.poll());
        }
        
        System.out.println(q.poll());
    }
}
