import java.util.*;
class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = new int[queries.length];
        
        for (int i = 0; i < queries.length; i++) {
            int min = Integer.MAX_VALUE;
            int a = queries[i][0];
            int b = queries[i][1];
            for (int j = a; j <= b; j++) {
                if (arr[j] > queries[i][2]) {
                    min = Math.min(min, arr[j]);
                }
            }
            if (min == Integer.MAX_VALUE) {
                answer[i] = -1;
            } else {
                answer[i] = min;
            }
        }
        
        return answer;
    }
}