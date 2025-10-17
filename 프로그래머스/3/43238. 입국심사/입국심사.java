import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);

        long left = 1; // 최소 시간
        long right = (long) times[times.length - 1] * n; // 최악의 경우 (가장 느린 심사관이 모두 심사)
        long answer = right;

        while (left <= right) {
            long mid = (left + right) / 2; // 현재 중간 시간
            long people = 0;

            // mid 시간 동안 심사 가능한 사람 수 계산
            for (int t : times) {
                people += mid / t;
                if (people >= n) break; // 이미 n명을 넘으면 더 볼 필요 없음
            }

            if (people >= n) {
                // 충분히 처리 가능 → 시간을 더 줄일 수 있음
                answer = mid;
                right = mid - 1;
            } else {
                // 아직 부족 → 시간을 늘림
                left = mid + 1;
            }
        }

        return answer;
    }
}