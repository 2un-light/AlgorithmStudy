import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Member[] members = new Member[N];

        for(int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            int age = Integer.parseInt(input[0]);
            String name = input[1];
            members[i] = new Member(age, name, i);
        }

        Arrays.sort(members, (m1, m2) -> {
            if(m1.age == m2.age){
                return Integer.compare(m1.index, m2.index);
            }
           return Integer.compare(m1.age, m2.age);
        });

        for(Member member : members){
            sb.append(member.age).append(" ").append(member.name).append("\n");
        }
        System.out.println(sb);

    }

    static class Member {
        int age;
        String name;
        int index;

        public Member(int age, String name, int index){
            this.age = age;
            this.name = name;
            this.index = index;
        }
    }
}
