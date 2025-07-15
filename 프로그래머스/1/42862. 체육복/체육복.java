import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) {
        int n = 5;
        int[] lost = {2, 4};
        int[] reserve = {1, 3, 5};

        System.out.println(solution(n, lost, reserve));
    }

    public static int solution(int n, int[] lost, int[] reserve) {
        Set<Integer> lostSet = new HashSet<>();
        Set<Integer> reserveSet = new HashSet<>();

        for(int l : lost) lostSet.add(l);
        for(int r : reserve) reserveSet.add(r);

        Set<Integer> intersect = new HashSet<>(lostSet);
        intersect.retainAll(reserveSet);

        lostSet.removeAll(intersect);
        reserveSet.removeAll(intersect);

        for(int r : new TreeSet<>(reserveSet)) {
            if (lostSet.contains(r - 1)) {
                lostSet.remove(r - 1);
            } else if (lostSet.contains(r + 1)) {
                lostSet.remove(r + 1);
            }
        }

        return n - lostSet.size();
    }
}
