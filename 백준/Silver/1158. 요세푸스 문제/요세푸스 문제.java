import java.io.*;
import java.util.*;
public class Main {
    public static int N; // 1번부터 N번까지 N명의 사람
    public static int K; // 순서대로 K번째 사람을 제거한다.
    public static LinkedList<Integer> list = new LinkedList<>();
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb.append("<");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        for (int i = 1; i <= N; i++) {
            list.offer(i);
        }
        
        
        while (list.size() > 1) {
            for (int i = 0; i < K - 1; i++) {
                int num = list.poll();
                
                list.offer(num);
            }
            sb.append(list.poll()).append(", ");
        }
        sb.append(list.poll()).append(">");
        System.out.println(sb);
                
    }
}