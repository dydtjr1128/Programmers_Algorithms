import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Solution {
    class User {
        User(String uid, String name) {
            this.uid = uid;
            this.name = name;
        }

        String uid;
        String name;
    }

    class Log {
        Log(User user, String state) {
            this.user = user;
            this.state = state;
        }

        User user;
        String state;
    }

    public String[] solution(String[] record) {
        String[] answer;
        int len = record.length;
        ArrayList<Log> logs = new ArrayList<>();
        HashMap<String, User> users = new HashMap();
        String temp[];
        char t;
        User user;
        String state[] = {"님이 들어왔습니다.", "님이 나갔습니다."};
        for (int i = 0; i < len; i++) {
            temp = record[i].split(" ");
            t = temp[0].charAt(0);
            if (t == 'E') {
                if(users.containsKey(temp[1])){
                    user = users.get(temp[1]);
                    user.name = temp[2];
                }
                else {
                    user = new User(temp[1], temp[2]);
                    users.put(temp[1], user);
                }
                logs.add(new Log(user, state[0]));
            } else if (t == 'L') {
                user = users.get(temp[1]);
                logs.add(new Log(user, state[1]));
            } else {
                user = users.get(temp[1]);
                user.name = temp[2];
            }

        }
        answer = new String[logs.size()];
        for (int i = 0; i < logs.size(); i++) {
            answer[i] = logs.get(i).user.name + logs.get(i).state;
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String logs[] = {"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"};
        System.out.println(Arrays.toString(solution.solution(logs)));
    }
}