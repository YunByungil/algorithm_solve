import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        
        int n = Integer.parseInt(br.readLine());
        
        if (n == 1) {
            System.out.println(1);
            return;
        }
        Queue<Integer> q = new LinkedList<>();
        
        for (int i = 1; i <= n; i++) {
            q.offer(i);
        }

        
        
        while(q.size() > 2) {
            q.poll();
            q.offer(q.poll());
        }
        
        q.poll();
        System.out.println(q.peek());
        
    }
}