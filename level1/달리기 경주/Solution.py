def solution(players, callings):
    # 선수 이름별 현재 위치
    positions = {name: i for i, name in enumerate(players)}

    for name in callings:
        current = positions[name]
        ahead_name = players[current - 1]

        # 두 선수의 순서와 위치 갱신
        players[current - 1], players[current] = players[current], players[current - 1]
        positions[name] = current - 1
        positions[ahead_name] = current

    return players