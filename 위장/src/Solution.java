import java.util.Collections;
import java.util.HashMap;
import java.util.Set;

public class Solution {

    public int solution(String[][] clothes) {
        int answer = 0;
        HashMap<String, Integer> maps = new HashMap<>();
        for (int i = 0; i < clothes.length; i++) {
            if (!maps.containsKey(clothes[i][1])) {
                maps.put(clothes[i][1], 1);
            } else {
                maps.put(clothes[i][1], maps.get(clothes[i][1]) + 1);
            }
        }
        int count = 1;

        for (String key : maps.keySet()) {
            count *= (maps.get(key) + 1);
        }
        answer = count - 1;
        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[][] temp = {{"yellow_hat", "hat"}, {"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}, {"green_turban", "head"}, {"green_turban", "head"}};
        System.out.println(solution.solution(temp));

    }
}