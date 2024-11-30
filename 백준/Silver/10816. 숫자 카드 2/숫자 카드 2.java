import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 상근이가 가지고 있는 숫자 카드 입력
        int N = Integer.parseInt(br.readLine());
        String[] cardsInput = br.readLine().split(" ");
        Map<Integer, Integer> cardCounts = new HashMap<>();

        // 카드 개수 세기
        for (int i = 0; i < N; i++) {
            int card = Integer.parseInt(cardsInput[i]);
            cardCounts.put(card, cardCounts.getOrDefault(card, 0) + 1);
        }

        // 체크해야 하는 카드 입력
        int M = Integer.parseInt(br.readLine());
        String[] chkCardsInput = br.readLine().split(" ");

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (String card : chkCardsInput) {
            int num = Integer.parseInt(card);
            sb.append(cardCounts.getOrDefault(num, 0)).append(" ");
        }

        System.out.println(sb.toString().trim());




    }
}
