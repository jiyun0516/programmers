def solution(schedules, timelogs, startday):
    answer = 0

    for schedule, logs in zip(schedules, timelogs):
        deadline = (schedule // 100) * 60 + (schedule % 100) + 10

        for day, arrival in enumerate(logs):
            weekday = (startday - 1 + day) % 7 + 1

            if weekday >= 6:
                continue
            arrival_minutes = (arrival // 100) * 60 + (arrival % 100)
            
            if arrival_minutes > deadline:
                break
                
        else:
            answer += 1

    return answer

