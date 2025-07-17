public class Solution {
    public static void main(String[] args) {
        String name = "JAZ";
        System.out.println(solution(name));
    }

    public static int solution(String name) {
        int cnt = 0;
        int move = name.length() - 1;

        for(int i = 0; i < name.length(); i++) {
            char c = name.charAt(i);
            int upDown = Math.min(c - 'A', 'Z' - c + 1);
            cnt += upDown;

            //좌우 이동 최소값 계산
            int next = i + 1;
            while(next < name.length() && name.charAt(next) == 'A') {
                next++;
            }

            move = Math.min(move, i * 2 + name.length() - next);
            move = Math.min(move, (name.length() - next) * 2 + i);

        }

        return cnt + move;
    }
}