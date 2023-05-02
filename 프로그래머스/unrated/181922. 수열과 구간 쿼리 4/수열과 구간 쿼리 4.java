class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = {};
        // query [s, e, k]
        // s <= i <= e     i에 대해 i가 k의 배수이면 arr[i]에 1을 더합니다.
        for (int i = 0; i < queries.length; i++) {
            int a = queries[i][0];
            int b = queries[i][1];
            for (int j = a; j <= b; j++) {
                if (j % queries[i][2] == 0) {
                    arr[j]++;
                }
            }
        }
        
        answer = arr;
        return answer;
    }
}