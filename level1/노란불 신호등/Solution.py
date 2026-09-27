from math import lcm

def solution(signals):
    # 모든 신호등의 상태가 다시 처음과 같아지는 시각
    repeat_time = lcm(*(g + y + r for g, y, r in signals))

    for time in range(1, repeat_time + 1):
        # 1초부터 시작하므로 time - 1로 주기 내 위치 계산
        if all(g <= (time - 1) % (g + y + r) < g + y
               for g, y, r in signals):
            return time

    return -1