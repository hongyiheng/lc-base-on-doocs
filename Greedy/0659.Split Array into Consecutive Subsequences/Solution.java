class Solution {
    public boolean isPossible(int[] nums) {
        Map<Integer, Integer> cnt = new HashMap<>(), tail = new HashMap<>();
        for (int v : nums) {
            cnt.put(v, cnt.getOrDefault(v, 0) + 1);
        }
        for (int i = -1000; i < 1001; i++) {
            while (cnt.getOrDefault(i, 0) > 0) {
                if (tail.getOrDefault(i - 1, 0) > 0) {
                    tail.put(i - 1, tail.get(i - 1) - 1);
                    tail.put(i, tail.getOrDefault(i, 0) + 1);
                    cnt.put(i, cnt.get(i) - 1);
                } else if (cnt.getOrDefault(i + 1, 0) > 0 && cnt.getOrDefault(i + 2, 0) > 0) {
                    cnt.put(i, cnt.get(i) - 1);
                    cnt.put(i + 1, cnt.get(i + 1) - 1);
                    cnt.put(i + 2, cnt.get(i + 2) - 1);
                    tail.put(i + 2, tail.getOrDefault(i + 2, 0) + 1);
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}