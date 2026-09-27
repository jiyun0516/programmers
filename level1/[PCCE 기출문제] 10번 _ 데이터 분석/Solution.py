def solution(data, ext, val_ext, sort_by):
    columns = ["code", "date", "maximum", "remain"]
    ext_idx = columns.index(ext)          # 필터링 기준 열
    sort_idx = columns.index(sort_by)     # 정렬 기준 열

    # 기준값보다 작은 데이터만 선택
    answer = [row for row in data if row[ext_idx] < val_ext]

    # 정렬 기준 열을 오름차순으로 정렬
    answer.sort(key=lambda row: row[sort_idx])

    return answer