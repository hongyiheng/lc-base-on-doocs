class Solution {
    Set<Integer> set = new HashSet<>();
    public int totalFruit(int[] fruits) {
        int ans = 0, l = 0;
        for (int r = 0; r < fruits.length; r++) {
            if (!set.contains(fruits[r])) {
                if (set.size() == 2) {
                    l = getLeft(fruits, r - 1);
                }
                set.add(fruits[r]);
            }
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }

    public int getLeft(int[] fruits, int right) {
        int cur = fruits[right];
        for (int l = right - 1; l >= 0; l--) {
            if (fruits[l] != cur) {
                set.remove(fruits[l]);
                return l + 1;
            }
        }
        return 0;
    }
}