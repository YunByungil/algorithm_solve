import java.util.*;
import java.io.*;
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int answer = 0;
        int m1 = Math.max(a, b);
        int m2 = Math.max(b, c);
        int max = Math.max(m1, m2);

        if (a == b && b == c) {

            answer = 10_000 + (a * 1000);
        } else if (a != b && b != c && a != c) {
            answer = max * 100;
        } else if ((a == b && b != c) || (b == c || a != c) || (a == c || b != c)) {
            if (a == b) {
                answer = 1_000 + (a * 100);
            } else if (b == c) {
                answer = 1_000 + (b * 100);
            } else if (a == c) {
                answer = 1_000 + (a * 100);
            }
        }

        System.out.println(answer);
    }
}