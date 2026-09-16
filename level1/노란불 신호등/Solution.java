class Solution {
    public int solution(int[][] signals) {
        long limit = 1;

        // 모든 신호등 주기의 최소공배수 계산
        for (int[] signal : signals) {
            int period = signal[0] + signal[1] + signal[2];
            limit = lcm(limit, period);
        }

        // 1초부터 전체 반복 주기까지 탐색
        for (int time = 1; time <= limit; time++) {
            boolean allYellow = true;

            for (int[] signal : signals) {
                int green = signal[0];
                int yellow = signal[1];
                int period = signal[0] + signal[1] + signal[2];

                // 현재 주기에서의 위치
                int current = (time - 1) % period;

                // 노란불이 아니면 확인 중단
                if (!(green <= current && current < green + yellow)) {
                    allYellow = false;
                    break;
                }
            }

            if (allYellow) {
                return time;
            }
        }

        return -1;
    }

    // 최대공약수
    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    // 최소공배수
    private long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }
}