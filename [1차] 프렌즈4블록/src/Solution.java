import java.util.HashSet;

public class Solution {
    public void print(int m, int n, char[][] map) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("------------------");
    }

    class Box {
        Box(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public boolean equals(Object obj) {
            Box box = (Box) obj;
            if (this.i == box.i && this.j == box.j)
                return true;
            return false;
        }

        @Override
        public int hashCode() {
            return (i + " " + j).hashCode();
        }

        int i;
        int j;
    }

    public int solution(int m, int n, String[] board) {
        int answer = 0;
        char map[][] = new char[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = board[i].charAt(j);
            }
        }
        print(m, n, map);
        HashSet<Box> hashSet = new HashSet<>();
        boolean isExist;
        while (true) {
            isExist = false;
            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n - 1; j++) {
                    if (map[i][j] == map[i + 1][j] && map[i][j] == map[i][j + 1] && map[i][j] == map[i + 1][j + 1] && map[i][j] >= 'A' && map[i][j] <= 'Z') {
                        hashSet.add(new Box(i, j));
                        hashSet.add(new Box(i + 1, j));
                        hashSet.add(new Box(i, j + 1));
                        hashSet.add(new Box(i + 1, j + 1));
                        isExist = true;
                    }
                }
            }
            if (!isExist)
                break;

            for (Box box : hashSet) {
                map[box.i][box.j] = '0';
            }
            hashSet.clear();
            int zeroStartIndex, charStartIndex;
            for (int i = 0; i < n; i++) {
                int j;
                zeroStartIndex = charStartIndex = -1;
                for (j = m - 1; j >= 0; j--) {
                    if (map[j][i] == '0') {
                        zeroStartIndex = j;
                        break;
                    }
                }
                for (; j >= 0; j--) {
                    if (map[j][i] != '0') {
                        charStartIndex = j;
                        break;
                    }
                }
                for (; zeroStartIndex >= 0 && charStartIndex >= 0; charStartIndex--, zeroStartIndex--)
                    map[zeroStartIndex][i] = map[charStartIndex][i];

                for (; zeroStartIndex >= 0; zeroStartIndex--)
                    map[zeroStartIndex][i] = '0';
            }
            print(m, n, map);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] >= 'A' && map[i][j] <= 'Z')
                    answer++;
            }
        }


        return n * m - answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        //System.out.println(solution.solution(6, 6, new String[]{"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"}));
        //System.out.println(solution.solution(6, 6, new String[]{"TTTAAA", "TTFACC", "TTRFCC", "TTRRAA", "TTMMMF", "TMMTTJ"}));
        System.out.println(solution.solution(4, 5, new String[]{"AAAAA", "AAAAA", "AAAAA", "AABAA"}));
        //System.out.println(solution.solution(6, 6, new String[]{"AAAAAT", "AATTTT", "TTTTTT", "TTTTTT", "TTTTTT", "TTTTTA"}));
        //System.out.println(solution.solution(6, 6, new String[]{"ABABAT", "BABATB", "ATBTBT", "DTDATD", "CTCTTD", "ABTCTA"}));
        //System.out.println(solution.solution(4, 5, new String[]{"CCBDE", "AAADE", "AAABF", "CCBBF"}));
        //System.out.println(solution.solution(2, 2, new String[]{"AA", "AA"}));

    }
}