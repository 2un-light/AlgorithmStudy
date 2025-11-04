import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        
        //데이터 기준 Map 만들기
        Map<String, Integer> indexMap = new HashMap<>();
        indexMap.put("code", 0);
        indexMap.put("date", 1);
        indexMap.put("maximum", 2);
        indexMap.put("remain", 3);
        
        //정해진 기준으로 데이터 뽑아내서 저장하기
        List<int[]> dataList = new ArrayList<>();
        for(int i = 0; i < data.length; i++) {
            int[] miniData = data[i];
            int extIdx = indexMap.get(ext);
            
            if(miniData[extIdx] < val_ext) {
                dataList.add(miniData);
            }
        }
        int sortIdx = indexMap.get(sort_by);
        Collections.sort(dataList, (a, b) -> a[sortIdx] - b[sortIdx]);
        
        int[][] result = new int[dataList.size()][4];
        for(int i = 0; i < dataList.size(); i++) {
            result[i] = dataList.get(i);
        }
        
        
        return result;
    }
}