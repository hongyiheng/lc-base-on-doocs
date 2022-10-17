class Solution {
    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> cnt = new HashMap<>();
        int l = 0, r = 0, n = fruits.length;
        int ans = 0, cur = 0;
        while (r < n) {
            while (r < n && (cnt.size() < 2 || cnt.containsKey(fruits[r]))) {
                cnt.put(fruits[r], cnt.getOrDefault(fruits[r], 0) + 1);
                cur++;
                r++;
            }
            ans = Math.max(ans, cur);
            while (cnt.size() == 2) {
                cnt.put(fruits[l], cnt.get(fruits[l]) - 1);
                if (cnt.get(fruits[l]) == 0) {
                    cnt.remove(fruits[l]);
                }
                l++;
                cur--;
            }
        }
        return ans;
    }
}
