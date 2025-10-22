import java.util.*;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
    
        
        //arr1 암호화 해제
        for(int i = 0; i < n; i++) {
            String binaryArr1 = Integer.toBinaryString(arr1[i]);
            String binaryArr2 = Integer.toBinaryString(arr2[i]);
            
            String result1 = plusZero(binaryArr1, n);
            String result2 = plusZero(binaryArr2, n);
            
            String input = "";
            for(int j = 0; j < n; j++) {
                int numA = result1.charAt(j) - '0';
                int numB = result2.charAt(j) - '0';
                
                if(numA + numB > 0) {
                    input += "#";
                }else {
                    input += " ";
                }    
            }    
            
            answer[i] = input;

        }
        
        return answer;
    }
    
    public String plusZero(String binaryArr, int n) {
        if(binaryArr.length() < n) {
            int num = n - binaryArr.length();
            while(num > 0) {
                binaryArr = "0" + binaryArr;
                num--;
            }
        }
        
        return binaryArr;
    }
}