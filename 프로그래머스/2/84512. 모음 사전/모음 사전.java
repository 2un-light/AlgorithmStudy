class Solution {
    public int solution(String word) {
        int[] weight = {781, 156, 31, 6, 1};
        String vowels = "AEIOU";
        int answer = 0;
        
        for(int i = 0; i < word.length(); i++) {
            int index = vowels.indexOf(word.charAt(i));
            answer += index * weight[i];
            answer += 1;
        }
        
        return answer;
        
    }
}