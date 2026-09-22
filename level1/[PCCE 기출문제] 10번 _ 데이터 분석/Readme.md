# [PCCE 기출문제] 10번 _ 데이터 분석

## 문제
[프로그래머스 - 데이터 분석] https://school.programmers.co.kr/learn/courses/30/lessons/250121

## 주요 제한사항
- 데이터는 `[code, date, maximum, remain]` 형식
- `data`의 길이: 최대 500
- `ext`에 해당하는 값이 `val_ext`보다 작은 데이터만 선택
- `sort_by`에 해당하는 값을 기준으로 오름차순 정렬

## 풀이 과정
`code`, `date`, `maximum`, `remain`을 배열에 저장하고, `ext`와 `sort_by`에 해당하는 열의 인덱스를 찾았다.

스트림의 `filter`를 사용하여 `ext` 값이 `val_ext`보다 작은 데이터만 선택했다.

선택한 데이터를 `sort_by`에 해당하는 값을 기준으로 오름차순 정렬한 후, 이차원 배열로 변환하여 반환했다.