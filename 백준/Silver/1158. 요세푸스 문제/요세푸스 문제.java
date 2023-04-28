import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static int n, k;
    public static LinkedList<Integer> list = new LinkedList<>();
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= n; i++) {
            list.offer(i);
        }

        sb.append("<");

        while (list.size() > 1) {
            for (int i = 0; i < k - 1; i++) {
                list.offer(list.poll());
            }

            sb.append(list.poll()).append(", ");
        }

        sb.append(list.poll()).append(">");

        System.out.println(sb);
    }
}