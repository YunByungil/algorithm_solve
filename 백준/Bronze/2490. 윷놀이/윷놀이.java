import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] arr = new int[2];
        
        for (int i = 0; i < 3; i++) {
            arr = new int[2];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                int num = Integer.parseInt(st.nextToken());
                arr[num]++;
            }

            if (arr[0] == 1) {
                sb.append("A").append("\n");
            } else if (arr[0] == 2) {
                sb.append("B").append("\n");
            } else if (arr[0] == 3) {
                sb.append("C").append("\n");
            } else if (arr[0] == 4) {
                sb.append("D").append("\n");
            } else if (arr[0] == 0) {
                sb.append("E").append("\n");
            }
        }

        System.out.println(sb);
    }
}
