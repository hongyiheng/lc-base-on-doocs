class Solution {
    public int countDistinctIntegers(int[] nums) {
        Set<Integer> s = new HashSet<>();
        for (int v : nums) {
            StringBuilder sb = new StringBuilder(String.valueOf(v));
            s.add(Integer.parseInt(sb.toString()));
            s.add(Integer.parseInt(sb.reverse().toString()));
        }
        return s.size();
    }
}
