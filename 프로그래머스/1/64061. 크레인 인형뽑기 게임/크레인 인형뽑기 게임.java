import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        
        Stack<Integer> basket = new Stack<>();
        
        for(int move : moves) {
            //해당 위치에서 인형을 하나 뽑음
            for(int i = 0; i < board.length; i++) {
                int doll = board[i][move - 1];
                if(doll != 0) {
                    board[i][move - 1] = 0;
                    
                    if(!basket.isEmpty() && basket.peek() == doll) {
                        basket.pop();
                        answer += 2;
                    }else {
                        basket.push(doll);
                    }
                    break;
                }
            }
        }
        
        for(int i : basket) {
            System.out.print(i + " ");
        }
        
        return answer;
    }
}