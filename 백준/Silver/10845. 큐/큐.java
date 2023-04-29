import java.io.*;
import java.util.*;

public class Main {
    public static int n; // 명령의 수
    public static LinkedList<Integer> q = new LinkedList<>();
   
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        
        
        for (int i = 0; i < n; i++) {
            
            
            String input = br.readLine();
            
            if (input.startsWith("push")) {
                int num = Integer.parseInt(input.substring(5, input.length()));
                
                q.offer(num);
            } else if (input.equals("pop")) {
                if (!q.isEmpty()) {
                    System.out.println(q.poll());
                } else {
                    System.out.println(-1);
                }
            } else if (input.equals("size")) {
                System.out.println(q.size());
            } else if (input.equals("empty")) {
                if (!q.isEmpty()) {
                    System.out.println(0);
                } else {
                    System.out.println(1);
                }
            } else if (input.equals("front")) {
                if (!q.isEmpty()) {
                    int firstNum = q.pollFirst();
                    System.out.println(firstNum);
                    q.addFirst(firstNum);
                } else {
                    System.out.println(-1);
                }
            } else if (input.equals("back")) {
                if (!q.isEmpty()) {
                    int lastNum = q.pollLast();
                    System.out.println(lastNum);
                    q.addLast(lastNum);
                } else {
                    System.out.println(-1);
                }
            }
        }
               
       
    }
}