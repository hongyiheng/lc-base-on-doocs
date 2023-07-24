class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        int ans = 0;
        for (char c : stones.toCharArray()) {
            if (jewels.indexOf(c) != -1) {
                ans++;
            }
        }
        return ans;
    }
}