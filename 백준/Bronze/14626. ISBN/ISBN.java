import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        
        //훼손된 곳의 인덱스 정보 저장 & 훼손되지 않은 정보 저장
        int idx = 0;
        int sum = 0;
        for(int i = 0; i < input.length(); i++) {
            if(input.charAt(i) == '*') {
                idx = i;
            }else {
                if(i % 2 == 0) {
                    sum += input.charAt(i) - '0';
                }else {
                    sum += (input.charAt(i) - '0') * 3;
                }
            }
        }

        int num = 0;
        while (true) {
            int check = sum;
            if(idx % 2 == 0) {
                check += num;
            }else {
                check += num * 3;
            }

            if(check % 10 == 0) {
                System.out.println(num);
                break;
            }else {
                num++;
            }
        }



    }
}
