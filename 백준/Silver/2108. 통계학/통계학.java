import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] numbers = new int[n];
        for(int i = 0; i < n; i++){
            int num = Integer.parseInt(br.readLine());
            numbers[i] = num;
        }

        Arrays.sort(numbers);

        //평균값
        System.out.println((int)mean(numbers));
        //중앙값
        System.out.println(median(numbers));
        //최빈값
        System.out.println(mode(numbers));
        //범위 계산
        System.out.println(range(numbers));

    }
    
    //평균값을 구하는 함수
    public static double mean(int[] numbers){
        double n = numbers.length;

        double sum = 0;
        for(int i = 0; i < numbers.length; i++){
            sum += numbers[i];
        }

        return  Math.round(sum / n);
    }

    //중앙값을 구하는 함수
    public static int median(int[] numbers){
        return numbers[numbers.length / 2];
    }

    //최빈값을 구하는 함수
    public static int mode(int[] numbers){
        Map<Integer, Integer> freq = new HashMap<>();
        //각 숫자의 빈도값 계산
        for(int num : numbers){
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        int maxFrequency = 0; //최빈값
        List<Integer> modeList = new ArrayList<>(); //최빈값 숫자들을 담는 리스트
        
        //가장 빈도가 높은 값 모으기
        for(int num : freq.keySet()){
            if(maxFrequency < freq.get(num)){
                maxFrequency = freq.get(num);
                modeList.clear();
                modeList.add(num);
            } else if (freq.get(num) == maxFrequency) {
                modeList.add(num);
            }
        }
        Collections.sort(modeList);
        //최빈값이 여러개
        if(modeList.size() > 1){
            return modeList.get(1);
        }else{
            return modeList.get(0);
        }
    }

    //범위를 구하는 함수
    public static int range(int[] numbers){
        return numbers[numbers.length - 1] - numbers[0];
    }
}
