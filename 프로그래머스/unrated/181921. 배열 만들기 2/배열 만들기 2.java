import java.util.*;
class Solution {
    public int[] solution(int l, int r) {
        int[] answer = {};
        List<Integer> list = new ArrayList<>();
        for (int i = l; i <= r; i++) {
            boolean result = isZeroOrFive(i);
            
            if (result) {
                list.add(i);
            }
        }
        
        if (list.size() > 0) {
            answer = new int[list.size()];
            int count = 0;
            for (Integer i : list) {
                answer[count++] = i;
            }
        } else {
            answer = new int[]{-1};
        }
        
        
        return answer;
    }
    
    public static boolean isZeroOrFive(int num) {
        while (num > 0) {
            
            if (num % 10 != 5 && num % 10 != 0) {
                return false;
            }
            
            num /= 10;
        }
        return true;
    }
}