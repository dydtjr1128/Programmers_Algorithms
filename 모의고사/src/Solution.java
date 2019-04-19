import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Solution {
    class People {
        People(int array[], int index) {
            this.array = array;
            this.index = index;
        }

        int count = 0;
        int array[];
        int index;
    }

    public int[] solution(int[] answers) {
        int[] answer = {};
        ArrayList<People> arrayList = new ArrayList<>();
        arrayList.add(new People(new int[]{1, 2, 3, 4, 5}, 1));
        arrayList.add(new People(new int[]{2, 1, 2, 3, 2, 4, 2, 5}, 2));
        arrayList.add(new People(new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5}, 3));
        int len = answers.length;
        int size = 3;
        People temp;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < size; j++) {
                temp = arrayList.get(j);
                if (answers[i] != temp.array[i % temp.array.length]) {
                    temp.count++;
                }
            }

        }
        Collections.sort(arrayList, new Comparator<People>() {
            @Override
            public int compare(People o1, People o2) {
                if (o1.count > o2.count)
                    return 1;
                else if (o1.count == o2.count)
                    return 0;
                else
                    return -1;
            }
        });
        int c = 1;
        for (int i = 1; i < arrayList.size(); i++) {
            if (arrayList.get(0).count == arrayList.get(i).count)
                c++;
        }
        answer = new int[c];
        for (int i = 0; i < c; i++) {
            answer[i] = arrayList.get(i).index;
        }
        Arrays.sort(answer);
        return answer;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(new int[]{1, 2, 3, 4, 5})));
        //System.out.println(Arrays.toString(solution.solution(new int[]{1, 3, 2, 4, 2})));

    }
}