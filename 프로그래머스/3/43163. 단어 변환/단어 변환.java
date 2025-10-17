import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        boolean found = false;
        for(String w : words) {
            if(w.equals(target)) {
                found = true;
                break;
            }
        }
        
        if(!found) return 0;
        
        
        boolean[] visited = new boolean[words.length];
        Queue<Word> queue = new LinkedList<>();
        
        queue.offer(new Word(begin, 0));
        
        while(!queue.isEmpty()) {
            Word cur = queue.poll();
            String curWord = cur.word;
            int cnt = cur.count;
            
            if(curWord.equals(target)) {
                return cnt;
            }
            
            for(int i = 0; i < words.length; i++) {
                if(!visited[i] && canConvert(curWord, words[i])) {
                    visited[i] = true;
                    queue.offer(new Word(words[i], cnt + 1));
                }
            }
        }
        
        return 0;
      
    }
    
    public boolean canConvert(String a, String b) {
        int diff = 0;
        for(int i = 0; i < a.length(); i++) {
            if(a.charAt(i) != b.charAt(i)) {
                diff++;
                if(diff > 1) {
                    return false;
                }
            }
        }
        return true;
    }
    
    
    
    class Word {
        String word;
        int count;
        Word(String w, int c) {
            this.word = w;
            this.count = c;
        }
    }
    
    
}
