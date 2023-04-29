import java.io.*;
import java.util.*;

public class Main {
    public static int n; // 명령의 수
    public static LinkedList<Integer> q = new LinkedList<>();
    public static StringBuilder sb = new StringBuilder();
   
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
                    sb.append(q.poll()).append("\n");
                    
                } else {
                    sb.append(-1).append("\n");
                    
                }
            } else if (input.equals("size")) {
                sb.append(q.size()).append("\n");
                
            } else if (input.equals("empty")) {
                if (!q.isEmpty()) {
                    sb.append(0).append("\n");
                } else {
                    sb.append(1).append("\n");
                }
            } else if (input.equals("front")) {
                if (!q.isEmpty()) {
                    int firstNum = q.pollFirst();
                    sb.append(firstNum).append("\n");
                    q.addFirst(firstNum);
                } else {
                    sb.append(-1).append("\n");
                }
            } else if (input.equals("back")) {
                if (!q.isEmpty()) {
                    int lastNum = q.pollLast();
                    sb.append(lastNum).append("\n");
                    q.addLast(lastNum);
                } else {
                    sb.append(-1).append("\n");
                }
            }
        }
        
        System.out.println(sb);
               
       
    }
}