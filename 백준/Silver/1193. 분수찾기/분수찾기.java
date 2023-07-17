import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int x = Integer.parseInt(br.readLine());
        int sum = 0;
        int count = 1;

        while (true) {
            if (x <= sum + count) {
                if (count % 2 == 0) {
                    System.out.println((x - sum) + "/" + (count - (x - sum - 1)));
                    break;
                } else {
                    System.out.println((count - (x - sum - 1)) + "/" + (x - sum));
                    break;
                }
            } else {
                sum += count;
                count++;
            }
        }
    }
}