import java.util.*;
import java.io.*;

public class Main {
    public static boolean state = false;
    public static int reverse = 1;
    public static LinkedList<Integer> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        // R: 뒤집기, D: 첫 번째 수 버리기 isEmpty일 때 D 사용하면 에러 발생
        // RDD는 배열을 뒤집은 다음, 처음 두 수를 버리는 함수
        
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            
            reverse = 1;
            state = false;
            q = new LinkedList<>();
            String p = br.readLine(); // 명령어
            
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n]; // 배열
            String str = br.readLine();
            if (n == -1) {
                System.out.println("error");
                continue;
            } else {
                arr = split(str);
                for (int j = 0; j < p.length(); j++) {
                    char command = p.charAt(j);
                    if (state) {
                        break;
                    }
                    if (command == 'R') {
                        reverse++;
                    } else {
                        poll();
                    }
                }
            }
            
            if (!state) {
                print();
            }
            System.out.println();
            
        }
    }
    
    public static int[] split(String input) {
        if (input.length() == 2) {
            return null;
        }
        input = input.substring(1, input.length() - 1);
        String[] stringArr = input.split(",");
        
        int[] intArr = new int[stringArr.length];
        for (int i = 0; i < intArr.length; i++) {
            intArr[i] = Integer.parseInt(stringArr[i]);
            q.offer(intArr[i]);
        }
        
        return intArr;
    }
    
    public static void poll() {
        if (q.isEmpty()) {
            System.out.print("error");
            state = true;
            return;
        }
        if (reverse % 2 != 0) {
            q.pollFirst();
        } else {
            q.pollLast();
        }
    }
    
    public static void print() {
        if (q.isEmpty()) {
            System.out.print("[]");
            return;
        }
        System.out.print("[");
        if (reverse % 2 != 0) {
            while (q.size() > 1) {
                System.out.print(q.poll() + ",");
            }
        } else {
            while (q.size() > 1) {
                System.out.print(q.pollLast() + ",");
            }
        }
        System.out.print(q.poll());
        System.out.print("]");
    }
}
