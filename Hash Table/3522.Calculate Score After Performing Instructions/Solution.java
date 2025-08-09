class Solution {
    public long calculateScore(String[] instructions, int[] values) {
        int n = instructions.length;
        Set<Integer> used = new HashSet<>();
        long ans = 0;
        int i = 0;
        while (0 <= i && i < n) {
            if (used.contains(i)) {
                break;
            }
            used.add(i);
            if ("add".equals(instructions[i])) {
                ans += values[i++];
            } else {
                i += values[i];
            }
        }
        return ans;
    }
}