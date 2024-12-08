import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Set<String> dancePeople = new HashSet<>();
        for(int i = 0; i < n; i++){
            String[] input = br.readLine().split(" ");
            String people1 = input[0];
            String people2 = input[1];
            
            //총총이가 옆에 있으면 춤추는 사람 명단에 넣기
            if(people1.equals("ChongChong") || people2.equals("ChongChong")){
                dancePeople.add(people1);
                dancePeople.add(people2);
            }
            
            //춤추는 사람 명단에 있는 사람과 함께 있으면 춤추는 사람 명단에 넣기
            if(dancePeople.contains(people1) || dancePeople.contains(people2)){
                dancePeople.add(people1);
                dancePeople.add(people2);
            }

        }

        System.out.println(dancePeople.size());
    }
}
