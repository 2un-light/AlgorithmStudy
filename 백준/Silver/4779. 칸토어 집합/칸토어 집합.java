import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line;
        while ((line = br.readLine()) != null && !line.isEmpty()) { // 파일 끝까지 입력 받기
            int n = Integer.parseInt(line);

            int length = (int) Math.pow(3, n); // 3^n 계산

            char[] arr = new char[length];
            for (int i = 0; i < length; i++) {
                arr[i] = '-'; // 초기화는 '-'로 해야 문제 조건과 맞음
            }

            cantor(arr, 0, length, n); // 칸토어 집합 생성 (end는 length로 설정)

            System.out.println(new String(arr)); // 결과 출력
        }
    }

    public static void cantor(char[] arr, int start, int length, int n) {
        if (n == 0) {
            return; // n이 0이면 더 이상 처리하지 않고 종료
        }

        int third = length / 3; // 현재 구간의 길이를 3등분
        for (int i = start + third; i < start + 2 * third; i++) {
            arr[i] = ' '; // 중간 구간을 공백으로 설정
        }

        // 왼쪽과 오른쪽 구간에 대해 재귀 호출
        cantor(arr, start, third, n - 1); // 왼쪽
        cantor(arr, start + 2 * third, third, n - 1); // 오른쪽
    }
}