import java.util.Arrays;

public class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        int len = citations.length;
        Arrays.sort(citations);

        for (int i = len-1; i >= 0; i--) {
            if (answer > citations[i]) {
                break;
            }
            answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[]{3, 0, 6, 1, 5}));
        //System.out.println(solution.solution(new int[]{3, 2}));
    }
}