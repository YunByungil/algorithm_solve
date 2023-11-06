import java.util.*;
import java.io.*;

public class Main {
    public static Deque<Integer> q = new ArrayDeque<>();
    public static Deque<Integer> q2 = new ArrayDeque<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        for (int i = 1; i <= n; i++) {
            q.offer(i);
            q2.offer(i);
        }

        st = new StringTokenizer(br.readLine());
        
        int answer = 0;
        
        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(st.nextToken());
            int left = findFirst(num);
            int right = findLast(num);
            
            if (left < right) {
                answer += pollFront(num);
            } else {
                answer += pollLast(num);
            }
        }
        
        System.out.println(answer);
    }
    
    public static int findFirst(int num) {
        int count = 0;
        Deque<Integer> copyQ = new ArrayDeque<>(q);
        while (true) {
            if (copyQ.peek().equals(num)) {
                copyQ.poll();
                break;
            } else {
                copyQ.offer(copyQ.pollFirst());
                count++;
            }
        }
        
        return count;
    }
    
    public static int findLast(int num) {
        int count = 0;
        Deque<Integer> copyQ = new ArrayDeque<>(q);
        while (true) {
            if (copyQ.peek().equals(num)) {
                copyQ.poll();
                break;
            } else {
                copyQ.offerFirst(copyQ.pollLast());
                count++;
            }
        }
        
        return count;
    }
    
    public static int pollFront(int num) {
        boolean b = true;
        int count = 0;
        while (b) {
            if (q.peek().equals(num)) {
                q.poll();
                break;
            } else {
                q.offer(q.pollFirst());
                count++;
            }
        }
        
        return count;
    }
    
    public static int pollLast(int num) {
        boolean b = true;
        int count = 0;
        while (b) {
            if (q.peek().equals(num)) {
                q.poll();
                break;
            } else {
                q.offerFirst(q.pollLast());
                count++;
            }
        }
        
        return count;
    }
}
