import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Set<String> people = new HashSet<>();
        int totalPeople = 0;
        for(int i = 0; i < n; i++){
            String name = br.readLine();
            if(name.equals("ENTER")){
                totalPeople += people.size();
                people.clear();
            }else{
                people.add(name);
            }
        }

        totalPeople += people.size();
        System.out.println(totalPeople);

    }
}
