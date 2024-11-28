import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        //중복제거를 위해 Set 사용
        Set<String> words = new HashSet<>();
        for(int i = 0; i < N; i++){
            words.add(br.readLine());
        }

        //리스트로 변환
        List<String> wordsList = new ArrayList<>(words);

        wordsList.sort((o1, o2) -> {
            if(o1.length() == o2.length()){
                return o1.compareTo(o2); //사전순
            }
            return Integer.compare(o1.length(), o2.length()); //길이순
        });

        for(String word : wordsList){
            System.out.println(word);
        }

    }
}
