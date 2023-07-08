import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] num = new int[9];
        int max = 0;
        int temp = 0;
        int index = 0;
        for (int i = 0; i < 9; i++) {
            num[i] = Integer.parseInt(br.readLine());
        }
        max = num[0];
        for (int i = 0; i < num.length; i++) {
            if (max < num[i]) {
                max = num[i];
                index = i + 1;
            }
        }
        if (index == 0) {
            index = 1;
        }
        System.out.println(max);
        System.out.println(index);
    }
}