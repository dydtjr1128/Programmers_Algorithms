import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> maps = new HashMap<>();
        int len = participant.length;
        int comLen = completion.length;
        for (int j = 0; j < len; j++) {
            if (maps.get(participant[j]) == null)
                maps.put(participant[j], 1);
            else
                maps.put(participant[j], maps.get(participant[j]) + 1);
        }
        for (int i = 0; i < comLen; i++) {
            if (maps.get(completion[i]) == 1)
                maps.remove(completion[i]);
            else
                maps.put(completion[i], maps.get(completion[i]) - 1);
        }
        for (String keys : maps.keySet()) {
            answer = keys;
            break;
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(new String[]{"marina", "josipa", "nikola", "vinko","nikola", "filipa"}, new String[]{"josipa", "filipa", "marina","nikola", "nikola"});
    }
}