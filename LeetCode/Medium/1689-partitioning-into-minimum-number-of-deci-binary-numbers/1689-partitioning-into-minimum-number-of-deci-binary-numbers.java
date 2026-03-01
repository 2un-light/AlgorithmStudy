class Solution {
    public int minPartitions(String n) {
        int max = 0;
        for(char c : n.toCharArray()) {
            int num = c - '0';
            max = Math.max(max, num);
        }

        return max;
    }
}