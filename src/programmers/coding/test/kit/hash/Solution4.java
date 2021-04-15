package programmers.coding.test.kit.hash;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * 베스트앨범
 * https://programmers.co.kr/learn/courses/30/lessons/42579
 *
 * genres	plays	return
 * ["classic", "pop", "classic", "classic", "pop"]	[500, 600, 150, 800, 2500]	[4, 1, 3, 0]
 */
//노래의 id, play, genre 를 담고있는 Song 객체를 만들어서 ArrayList에 삽입한다.
// 동시에 각 장르별 play를 합산하여 HashMap에 기록한다.
//        Comparator를 생성하여 정렬한다.
//        정렬된 리스트를 바탕으로 베스트앨범 수록곡을 선정한다. 이때 장르별 2곡이라는 기준을 만족하기 위해 HashMap으로 장르별 수록곡 수를 저장한다.

public class Solution4{
    static class Song implements Comparable<Song>{
        private int index;
        private int plays;
        private String genre;

        public Song(int index, int plays, String genre) {
            this.index = index;
            this.plays = plays;
            this.genre = genre;
        }

        /**
         * o가 this 보다 작으면 양의 정수
         * o가 this 보다 크면 음의 정수
         * o와 this 같으면 0
         * @param o
         * @return
         */
        @Override
        public int compareTo(Song o) {
//        장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.
            if(this.plays == o.plays){
                return this.index - o.index;
            }
//        장르 내에서 많이 재생된 노래를 먼저 수록합니다.
            else {
                return o.plays - this.plays;
            }
        }
    }

    /*
    String[] genres = {"A", "A", "B", "A", "B", "B", "A", "A", "A", "A"};
int[] plays = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
[0, 1, 2, 4]
     */
    public static void main(String[] args) {
//        String[] genres = new String[]{"classic", "pop", "classic", "classic", "pop"};
//        int[] plays = new int[]{500, 600, 150, 800, 2500};
        String[] genres = new String[]{"A", "A", "B", "A", "B", "B", "A", "A", "A", "A"};
        int[] plays = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        System.out.println(solution(genres, plays));
    }

    public static int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> genreMap = new HashMap<>();
        ArrayList<Song> list = new ArrayList<>();
        for (int i = 0; i < genres.length; i++) {
            Song song = new Song(i, plays[i], genres[i]);
            list.add(song);
            genreMap.put(genres[i], genreMap.getOrDefault(genres[i], 0) + plays[i]);
        }

        Collections.sort(list, (s1, s2) -> {
            if(s1.genre.equals(s2.genre)){
                return s1.compareTo(s2);
            } else {
                return -(genreMap.get(s1.genre) - genreMap.get(s2.genre));
            }
        });
        ArrayList<Integer> bestAlbumList = new ArrayList<>();
        for (Song song : list) {
             if(genreMap.containsKey(song.genre)){
                 Integer count = genreMap.get(song.genre);
                 switch (count){
                     case 1:
                         bestAlbumList.add(song.index);
                         genreMap.put(song.genre,0);
                         break;
                     case 0:
                         genreMap.remove(song.genre);
                         break;
                     default:
                         bestAlbumList.add(song.index);
                         genreMap.put(song.genre,1);
                         break;
                 }
             }
        }

        int[] bestAlbum = new int[bestAlbumList.size()];
        for (int i = 0; i < bestAlbum.length; i++) {
            bestAlbum[i] = bestAlbumList.get(i);
        }
        return bestAlbum;
    }
}
