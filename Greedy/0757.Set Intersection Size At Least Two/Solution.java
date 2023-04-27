class Solution {
    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
        List<Integer> ans = new ArrayList<>();
        Set<Integer> use = new HashSet<>();
        for (int[] interval : intervals) {
            int l = interval[0], r = interval[1];
            int need = 2;
            if (ans.size() >= 1 && ans.get(ans.size() - 1) >= l) {
                need--;
            }
            if (ans.size() >= 2 && ans.get(ans.size() - 2) >= l) {
                need--;
            }
            if (need == 2) {
                ans.add(r - 1);
                ans.add(r);
                use.add(r);
            } else if (need == 1) {
                if (!use.contains(r)) {
                    ans.add(r);
                } else {
                    ans.add(r - 1);
                }
                use.add(r);
            }
        }
        return ans.size();
    }
}