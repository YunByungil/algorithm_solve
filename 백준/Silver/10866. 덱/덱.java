import java.util.*;
import java.io.*;

public class Main {
    public static int n; // 명령의 수
    public static LinkedList<Integer> q = new LinkedList<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        n = Integer.parseInt(br.readLine());
        
        
        for (int i = 0; i < n; i++) {
            
            String str = br.readLine();
            
            
            if (str.startsWith("push_front")) {
                int num = Integer.parseInt(str.substring(11, str.length()));
                q.offerFirst(num);
            } else if (str.startsWith("push_back")) {
                int num = Integer.parseInt(str.substring(10, str.length()));
                q.offerLast(num);
            } else if (str.equals("pop_front")) {
                if (!q.isEmpty()) {
                    System.out.println(q.pollFirst());
                } else {
                    System.out.println(-1);
                }
            } else if (str.equals("pop_back")) {
                if (!q.isEmpty()) {
                    
                    System.out.println(q.pollLast());
                    
                } else {
                    System.out.println(-1);
                }
            } else if (str.equals("size")) {
                System.out.println(q.size());
            } else if (str.equals("empty")) {
                if (!q.isEmpty()) {
                    System.out.println(0);
                } else {
                    System.out.println(1);
                }
            } else if (str.equals("front")) {
                if (!q.isEmpty()) {
                    System.out.println(q.peekFirst());
                } else {
                    System.out.println(-1);
                }
            } else if (str.equals("back")) {
                if (!q.isEmpty()) {
                    System.out.println(q.peekLast());
                } else {
                    System.out.println(-1);
                }
            }
        }
        
        
        
    }
}