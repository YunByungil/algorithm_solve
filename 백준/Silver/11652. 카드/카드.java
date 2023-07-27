import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int maxCount = 0;
        long maxValue = Long.MIN_VALUE;
        int count = 0;
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }
        Arrays.sort(arr);

        for (int i = 0; i < n; i++) {
            if (i == 0 || arr[i - 1] == arr[i]) {
                count++;
            } else {
                if (count > maxCount) {
                    maxValue = arr[i - 1];
                    maxCount = count;
                }

                count = 1;
            }
        }

        if (count > maxCount) {
            maxValue = arr[n - 1];
        }

        System.out.println(maxValue);
    }
}