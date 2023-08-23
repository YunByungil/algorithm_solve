import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int[] arr = new int[10];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String n = br.readLine();

        for (int i = 0; i < n.length(); i++) {
            int num = n.charAt(i) - '0';
            arr[num]++;
        }
        int needNum = 0;
        int needNine = 0;
        int needSix = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                if (i == 9) {
                    needNine = arr[i];
                } else if (i == 6) {
                    needSix = arr[i];  
                } else {
                    needNum = Math.max(needNum, arr[i]);
                }
            }
        }
        int need = (int) Math.ceil((needNine + needSix) / 2.0);

        int result = Math.max(need, needNum);
        System.out.println(result);
    }
}