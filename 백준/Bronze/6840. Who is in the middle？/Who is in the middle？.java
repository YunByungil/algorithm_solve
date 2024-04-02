import java.util.*;
import java.io.*;

public class Main {
    public static int n, k, t, w;
    public static int[] arr, tmp;
    public static int[] dp;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));        
        StringTokenizer st = null;
        
        Scanner sc = new Scanner(System.in);
        int number1 = sc.nextInt();
        int number2 = sc.nextInt();
        int number3 = sc.nextInt();

        ArrayList<Integer> list = new ArrayList<>();
        list.add(number1);
        list.add(number2);
        list.add(number3);
        //(1)
        Collections.sort(list);
		//(2)
        System.out.println(list.get(1));
    }
}
    
    
