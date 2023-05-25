import java.util.*;
import java.io.*;

public class Main {
    public static int n, w, l; // n: 다리를 건너는 트럭 수, w: 다리 길이, l: 다리 최대 하중
    public static Queue<Integer> bridge = new LinkedList<>();
    public static Queue<Integer> truck = new LinkedList<>();
    public static int now, time;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int truckWeight = Integer.parseInt(st.nextToken());
            truck.offer(truckWeight);
        }
        
        for (int i = 0; i < w; i++) {
            bridge.offer(0);
        }
        
        while (!bridge.isEmpty()) {
            time++;
            int bridgeWeight = bridge.poll();
            now -= bridgeWeight;
            
            if (!truck.isEmpty()) {
                if (now + truck.peek() <= l) {
                    int truckWeight = truck.poll();
                    bridge.offer(truckWeight);
                    now += truckWeight;
                } else {
                    bridge.offer(0);
                }
            }
        }
        
        System.out.println(time);
    }    
}