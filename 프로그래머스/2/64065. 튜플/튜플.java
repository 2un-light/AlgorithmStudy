import java.util.*;

class Solution {
    public int[] solution(String s) {
        //앞 뒤 {{}} 제거
        s = s.substring(2, s.length() - 2);
        
        //},{ 기준으로 split
        String[] sets = s.split("\\},\\{");
        
        //각 집합 길이순 정렬
        Arrays.sort(sets, (a, b) -> a.length() - b.length());
        
        List<Integer> result = new ArrayList<>();
        
        for(String set : sets) {
            String[] nums = set.split(",");
            for(String num : nums) {
                int n = Integer.parseInt(num);
                if(!result.contains(n)) {
                    result.add(n);
                }
            }
        }
        
        return result.stream().mapToInt(Integer::intValue).toArray();
        
    }
}