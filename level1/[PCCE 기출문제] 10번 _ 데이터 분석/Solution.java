import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        String[] columns = {"code", "date", "maximum", "remain"};

        // 필터링과 정렬에 사용할 열 번호 찾기
        int extIndex = 0;
        int sortIndex = 0;

        for (int i = 0; i < columns.length; i++) {
            if (columns[i].equals(ext)) {
                extIndex = i;
            }

            if (columns[i].equals(sort_by)) {
                sortIndex = i;
            }
        }

        final int filterColumn = extIndex;
        final int sortColumn = sortIndex;

        // 조건에 맞는 데이터를 선택하고 지정된 열을 기준으로 정렬
        return Arrays.stream(data)
                .filter(row -> row[filterColumn] < val_ext)
                .sorted(Comparator.comparingInt(row -> row[sortColumn]))
                .toArray(int[][]::new);
    }
}