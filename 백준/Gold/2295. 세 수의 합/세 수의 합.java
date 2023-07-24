import java.util.*;
import java.io.*;

public class Main {
    public static int n, answer;
    public static int[] arr;
    public static List<Integer> list = new ArrayList<>();
    public static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                
                list.add(arr[i] + arr[j]);
            }
        }
        Collections.sort(list);
        
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                int num = arr[i] - arr[j];
                
                if (binarySearch(num) && arr[i] > answer) {
                    answer = arr[i];
                }
            }
        }
        
        System.out.println(answer);
        
        
    }
    
    public static boolean binarySearch(int num) {
        int start = 0;
        int end = list.size();
        
        while (start < end) {
            int mid = (start + end) / 2;
            
            if (list.get(mid) == num) {
                return true;
            } else if (list.get(mid) > num) {
                end = mid;
            } else if (list.get(mid) < num) {
                start = mid + 1;
            }
        }
        
        return false;
    }
}
