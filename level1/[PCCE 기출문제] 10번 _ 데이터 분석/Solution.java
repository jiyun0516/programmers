import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        // 각 데이터 항목의 열 이름
        String[] columns = {"code", "date", "maximum", "remain"};

        int extIndex = 0;   // 필터링 기준 열
        int sortIndex = 0;  // 정렬 기준 열

        // ext와 sort_by에 해당하는 열 번호 찾기
        for (int i = 0; i < columns.length; i++) {
            if (columns[i].equals(ext)) {
                extIndex = i;
            }

            if (columns[i].equals(sort_by)) {
                sortIndex = i;
            }
        }

        // 람다식에서 사용할 수 있도록 final 변수로 저장
        final int filterColumn = extIndex;
        final int sortColumn = sortIndex;

        return Arrays.stream(data)
                // ext 값이 val_ext보다 작은 데이터만 선택
                .filter(row -> row[filterColumn] < val_ext)
                // sort_by에 해당하는 값을 기준으로 오름차순 정렬
                .sorted(Comparator.comparingInt(row -> row[sortColumn]))
                // 스트림을 int[][] 배열로 변환
                .toArray(int[][]::new);
    }
}