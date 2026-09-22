import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> rank = new HashMap<>();

        // 선수별 현재 위치 저장
        for (int i = 0; i < players.length; i++) {
            rank.put(players[i], i);
        }

        for (String calling : callings) {

            // 추월한 선수의 현재 위치
            int currentIndex = rank.get(calling);

            // 바로 앞 선수
            String frontPlayer = players[currentIndex - 1];

            // 배열에서 두 선수 위치 교환
            players[currentIndex - 1] = calling;
            players[currentIndex] = frontPlayer;

            // HashMap의 위치도 수정
            rank.put(calling, currentIndex - 1);
            rank.put(frontPlayer, currentIndex);
        }

        return players;
    }
}