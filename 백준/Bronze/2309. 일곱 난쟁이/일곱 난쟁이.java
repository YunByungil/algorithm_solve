import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = 9;
        int max = 0;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            arr[i] = num;
            max += num;
        }

        int start = 0;
        int end = 0;
        int sIndex = 0;
        int eIndex = 0;
        int result = 0;
        for (int i = 0; i < 8; i++) {
            start = arr[i];
            result = 0;
            for (int j = i + 1; j < 9; j++) {
                end = arr[j];
                int num = start + end;

                result = max - num;
                if (result == 100) {
                    sIndex = i;
                    eIndex = j;
                    break;
                }
            }
            if (result == 100) {
                break;
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (i == sIndex || i == eIndex) {
                continue;
            }
            list.add(arr[i]);
        }

        Collections.sort(list);
        for (Integer i : list) {
            System.out.println(i);
        }
        
        
    }
}
    
    
