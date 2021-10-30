class Solution {
    public int longestWPI(int[] hours) {
        int sum = 0;
        int res = 0;
        Map<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < hours.length; i++) {
            int temp = hours[i] > 8 ? 1 : -1;
            sum += temp;
            if (sum > 0) {
                res = i + 1;
            } else {
                if (!mp.containsKey(sum)) {
                    mp.put(sum, i);
                }
                if (mp.containsKey(sum - 1)) {
                    res = Math.max(res, i - mp.get(sum - 1));
                }
            }
        }
        return res;
    }
}