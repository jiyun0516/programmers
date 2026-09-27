def solution(video_len, pos, op_start, op_end, commands):
    # "mm:ss"를 초로 변환
    def to_seconds(time):
        minutes, seconds = map(int, time.split(":"))
        return minutes * 60 + seconds

    video_end = to_seconds(video_len)
    current = to_seconds(pos)
    opening_start = to_seconds(op_start)
    opening_end = to_seconds(op_end)

    # 오프닝 구간에 있으면 끝 위치로 이동
    def skip_opening(position):
        if opening_start <= position <= opening_end:
            return opening_end
        return position

    # 시작 위치에도 오프닝 건너뛰기 적용
    current = skip_opening(current)

    for command in commands:
        if command == "prev":
            current = max(0, current - 10)
        else:
            current = min(video_end, current + 10)

        # 명령을 실행한 뒤 오프닝 구간인지 확인
        current = skip_opening(current)

    # 초를 "mm:ss" 형식으로 변환
    return f"{current // 60:02d}:{current % 60:02d}"