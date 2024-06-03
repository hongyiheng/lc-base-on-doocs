class Solution {
    public int[] distributeCandies(int candies, int num_people) {
        int[] ans = new int[num_people];
        int i = 0, t = 1;
        while (candies > 0) {
            int v = Math.min(t, candies);
            ans[i % num_people] += v;
            candies -= v;
            t++;
            i++;
        }
        return ans;
    }
}