# [PCCE 기출문제] 10번 _ 데이터 분석

## 문제
[프로그래머스 - 데이터 분석](https://school.programmers.co.kr/learn/courses/30/lessons/250121)

## 주요 제한사항
- 데이터는 `[code, date, maximum, remain]` 형식
- `data`의 길이: 최대 500
- `ext`에 해당하는 값이 `val_ext`보다 작은 데이터만 선택
- `sort_by`에 해당하는 값을 기준으로 오름차순 정렬

## 풀이 과정
`["code", "date", "maximum", "remain"]`에서 `index()`로 `ext`와 `sort_by`에 해당하는 열 번호를 찾았다.

리스트 컴프리헨션으로 `ext` 값이 `val_ext`보다 작은 데이터만 선택했다.

선택한 데이터를 `sort()`의 `key`에 정렬 기준 열을 지정하여 오름차순으로 정렬한 뒤 반환했다.