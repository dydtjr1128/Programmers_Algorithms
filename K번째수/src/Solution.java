import java.util.Arrays;

public class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            int tArray[] = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
            Arrays.sort(tArray);
            answer[i] = tArray[commands[i][2]-1];
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int array[] = {1, 5, 2, 6, 3, 7, 4};
        int commands[][] = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        System.out.println(Arrays.toString(solution.solution(array, commands)));

    }
}