class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < Math.pow(2, n); i++) {
            ans.add(i ^ (i >> 1));
        }
        return ans;
    }
}