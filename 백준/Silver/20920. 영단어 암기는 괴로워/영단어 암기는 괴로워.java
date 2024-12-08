import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        //단어 저장 Map
        Map<String, Integer> wordMap = new HashMap<>();
        for(int i = 0; i < n; i++){
            String word = br.readLine();
            if(word.length() >= m){
                wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
            }
        }

        //정렬
        List<Map.Entry<String, Integer>> wordDictionary = new ArrayList<>(wordMap.entrySet());
        wordDictionary.sort((word1, word2) -> {
            //빈도순으로
            if(word1.getValue() != word2.getValue()){
                return word2.getValue() - word1.getValue();
            }

            //단어 길이순
            if(word1.getKey().length() != word2.getKey().length()){
                return word2.getKey().length() - word1.getKey().length();
            }

            //알파벳 사전 순으로
            return word1.getKey().compareTo(word2.getKey());
        });

        for(Map.Entry<String, Integer> word : wordDictionary){
            sb.append(word.getKey()).append("\n");
        }
        System.out.println(sb);

    }
}