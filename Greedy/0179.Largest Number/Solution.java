class Solution {
    public String largestNumber(int[] nums) {
        int n = nums.length;
        String[] s = new String[n];
        for (int i = 0; i < n; i++) {
            s[i] = "" + nums[i];
        }
        Arrays.sort(s, (a, b) -> {
            return (b + a).compareTo(a + b) > 0 ? 1 : -1;
        });
        StringBuilder ans = new StringBuilder();
        for (String v : s) {
            ans.append(v);
        }
        while (ans.length() > 1 && ans.charAt(0) == '0') {
            ans = ans.deleteCharAt(0);
        }
        return ans.toString();
    }
}