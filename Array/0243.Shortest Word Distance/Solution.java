class Solution {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < wordsDict.length; i++) {
            if (wordsDict[i].equals(word1)) {
                nums.add(i);
            }
        }
        int ans = wordsDict.length;
        for (int i = 0; i < wordsDict.length; i++) {
            if (wordsDict[i].equals(word2)) {
                int left = 0, right = nums.size() - 1;
                while (left < right) {
                    int mid = (left + right) >> 1;
                    if (nums.get(mid) < i) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }
                if (left > 0 && Math.abs(nums.get(left - 1) - i) < Math.abs(nums.get(left) - i)) {
                    left = left - 1;
                }
                ans = Math.min(ans, Math.abs(nums.get(left) - i));
            }
        }
        return ans;
    }
}