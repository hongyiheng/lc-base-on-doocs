/*
 * // This is the custom function interface.
 * // You should not implement it, or speculate about its implementation
 * class CustomFunction {
 *     // Returns f(x, y) for any given positive integers x and y.
 *     // Note that f(x, y) is increasing with respect to both x and y.
 *     // i.e. f(x, y) < f(x + 1, y), f(x, y) < f(x, y + 1)
 *     public int f(int x, int y);
 * };
 */

class Solution {
    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        int M = 1000;
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 1; i < M + 1; i++) {
            int l = 1, r = M;
            while (l < r) {
                int mid = (l + r) >> 1;
                if (customfunction.f(i, mid) < z) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            if (customfunction.f(i, l) == z) {
                ans.add(Arrays.asList(i, l));
            }
        }
        return ans;
    }
}