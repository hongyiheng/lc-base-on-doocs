class Solution {
    public List<Integer> stableMountains(int[] height, int threshold) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < height.length - 1; i++) {
            if (height[i] > threshold) {
                ans.add(i + 1);
            }
        }
        return ans;
    }
}