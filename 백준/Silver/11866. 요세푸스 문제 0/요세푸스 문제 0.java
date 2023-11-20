import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        
        Queue<Integer> list = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            list.offer(i);
        }
        
        List<Integer> answer = new ArrayList<>();
        while (list.size() > 1) {
            for (int i = 0; i < k - 1; i++) {
                int out = list.poll();
                list.offer(out);
            }
            
            int result = list.poll();
            sb.append(result).append(", ");
            answer.add(result);
        }
        int lastNumber = list.poll();
        sb.append(lastNumber).append(">");
        answer.add(lastNumber);
        
        System.out.println(sb);        
    }
}
