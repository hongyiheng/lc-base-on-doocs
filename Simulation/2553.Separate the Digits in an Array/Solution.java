class Solution {
    public int[] separateDigits(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        for (int v : nums) {
            Deque<Integer> t = new ArrayDeque<>();
            while (v > 0) {
                t.addFirst(v % 10);
                v /= 10;
            }
            ans.addAll(new ArrayList<>(t));
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}