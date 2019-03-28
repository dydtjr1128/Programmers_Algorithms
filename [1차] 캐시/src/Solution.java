import java.util.ArrayList;

public class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        ArrayList<String> queue = new ArrayList<>(cacheSize);
        int len = cities.length;
        boolean isExist;
        int index=0;
        String temp;
        if(cacheSize==0)
            return len*5;
        for (int i = 0; i < len; i++) {
            isExist = false;
            temp = cities[i].toLowerCase();
            for (int j = 0; j < queue.size(); j++) {
                if (queue.get(j).equals(temp)) {
                    isExist = true;
                    index = j;
                    break;
                }
            }
            if (isExist) {
                answer += 1;
                temp = queue.get(index);
                queue.remove(index);
                queue.add(temp);
            } else {
                answer += 5;
                if (queue.size() == cacheSize) {
                    queue.remove(0);
                    queue.add(temp);
                }
                else
                    queue.add(temp);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        //System.out.println(solution.solution(3, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"}));
        //System.out.println(solution.solution(3, new String[]{"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"}));
        System.out.println(solution.solution(2, new String[]{"Jeju", "Pangyo", "NewYork", "newyork"}));
    }
}