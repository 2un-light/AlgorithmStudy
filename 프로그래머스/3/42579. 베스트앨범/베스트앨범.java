import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};

        System.out.println(solution(genres, plays));

    }

    public static int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> genrePlayCount = new HashMap<>();
        Map<String, List<Song>> songsByGenre = new HashMap<>();

        for(int i = 0; i < genres.length; i++) {
            genrePlayCount.put(genres[i], genrePlayCount.getOrDefault(genres[i], 0) + plays[i]);
            songsByGenre.computeIfAbsent(genres[i], k -> new ArrayList<>()).add(new Song(i, plays[i]));
        }

        //장르를 재생 수 기준 정렬
        List<String> genreOrder = new ArrayList<>(genrePlayCount.keySet());
        genreOrder.sort((a, b) -> genrePlayCount.get(b) - genrePlayCount.get(a));

        List<Integer> result = new ArrayList<>();

        for(String genre : genreOrder) {
            List<Song> songs = songsByGenre.get(genre);

            songs.sort((a, b) -> {
                if(b.plays != a.plays) {
                    return b.plays - a.plays;
                }else {
                    return a.id - b.id;
                }
            });

            for(int i= 0; i < Math.min(2, songs.size()); i++) {
                result.add(songs.get(i).id);
            }
        }

       return result.stream().mapToInt(i -> i).toArray();

    }

}

class Song {
    int id;
    int plays;

    Song(int id, int plays) {
        this.id = id;
        this.plays = plays;
    }
}
