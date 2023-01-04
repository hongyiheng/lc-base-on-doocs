class Solution {
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> ans = new ArrayList<>();
        int left = 0, right = 0, n = s.length();
        while (right < n) {
            if (s.charAt(right) != s.charAt(left)) {
                if (right - left >= 3) {
                    List<Integer> list = new ArrayList<>();
                    list.add(left);
                    list.add(right - 1);
                    ans.add(list);
                }
                left = right;
            }
            right++;
        }
        if (right - left >= 3) {
            List<Integer> list = new ArrayList<>();
            list.add(left);
            list.add(right - 1);
            ans.add(list);
        }
        return ans;
    }
}