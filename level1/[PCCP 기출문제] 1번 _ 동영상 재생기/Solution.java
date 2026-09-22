class Solution {
    public String solution(String video_len, String pos, String op_start,
                           String op_end, String[] commands) {

        // 모든 시간을 초 단위로 변환
        int videoLen = toSeconds(video_len);
        int current = toSeconds(pos);
        int opStart = toSeconds(op_start);
        int opEnd = toSeconds(op_end);

        // 시작 위치가 오프닝 구간이면 오프닝 끝으로 이동
        if (opStart <= current && current <= opEnd) {
            current = opEnd;
        }

        // 명령을 순서대로 실행
        for (String command : commands) {

            // 10초 전으로 이동하되, 0초보다 앞으로 갈 수 없음
            if (command.equals("prev")) {
                current = Math.max(0, current - 10);
            }

            // 10초 후로 이동하되, 동영상 길이를 넘을 수 없음
            else {
                current = Math.min(videoLen, current + 10);
            }

            // 이동한 위치가 오프닝 구간이면 오프닝 끝으로 이동
            if (opStart <= current && current <= opEnd) {
                current = opEnd;
            }
        }

        // 최종 위치를 분과 초로 변환
        int minute = current / 60;
        int second = current % 60;

        // "mm:ss" 형식으로 변환하여 반환
        String answer = String.format("%02d:%02d", minute, second);
        return answer;
    }

    // "mm:ss" 형식의 문자열을 초 단위로 변환
    private int toSeconds(String time) {
        String[] parts = time.split(":");

        int minute = Integer.parseInt(parts[0]);
        int second = Integer.parseInt(parts[1]);

        return minute * 60 + second;
    }
}