import java.util.*;

public class Solution {
    class Album {
        Album(int play, int index) {
            this.play = play;
            this.index = index;
        }

        int play;
        int index;
    }

    class Genres {
        Genres(String genres, int count) {
            this.genres = genres;
            this.count = count;
        }

        String genres;
        int count;
    }

    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, ArrayList<Album>> maps = new HashMap<>();

        int[] answer = {};
        int len = genres.length;
        ArrayList<Album> albums;
        HashMap<String, Genres> genresMap = new HashMap<>();

        for (int i = 0; i < len; i++) {
            if (!maps.containsKey(genres[i])) {
                albums = new ArrayList<>();
                albums.add(new Album(plays[i], i));
                maps.put(genres[i], albums);
                genresMap.put(genres[i], new Genres(genres[i], plays[i]));
            } else {
                maps.get(genres[i]).add(new Album(plays[i], i));
                Genres t = genresMap.get(genres[i]);
                t.count += plays[i];
            }
        }

        for (String key : maps.keySet()) {
            Collections.sort(maps.get(key), new Comparator<Album>() {
                @Override
                public int compare(Album o1, Album o2) {
                    if (o1.play < o2.play)
                        return 1;
                    else if (o1.play > o2.play)
                        return -1;
                    else
                        return 0;
                }
            });
        }
        List<Genres> genresArrayList = new ArrayList<Genres>(genresMap.values());
        Collections.sort(genresArrayList, new Comparator<Genres>() {
            @Override
            public int compare(Genres o1, Genres o2) {
                if (o1.count < o2.count)
                    return 1;
                else if (o1.count > o2.count)
                    return -1;
                else
                    return 0;
            }
        });
        List<Integer> answers = new ArrayList<>();
        for (int i = 0; i < genresArrayList.size(); i++) {
            albums = maps.get(genresArrayList.get(i).genres);
            for(int j=0; j<albums.size() && j<2;j++) {
                answers.add(albums.get(j).index);
            }
        }
        answer = answers.stream().mapToInt(i -> i).toArray();
        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String geners[] = {"classic", "pop", "classic", "classic", "pop"};
        int plays[] = {500, 600, 150, 800, 2500};
        System.out.println(Arrays.toString(solution.solution(geners,plays)));

    }
}