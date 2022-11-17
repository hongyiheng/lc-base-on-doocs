class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        Map<Character, List<Integer>> mp = new HashMap<>();
        char[] cs = s.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            mp.computeIfAbsent(cs[i], k -> new ArrayList<>()).add(i);
        }
        int ans = 0;
        for (String w : words) {
            char[] ws = w.toCharArray();
            boolean flag = true;
            int cur = -1;
            for (int i = 0; i < ws.length; i++) {
                char c = ws[i];
                List<Integer> ids = mp.getOrDefault(c, new ArrayList<>());
                int left = 0, right = ids.size();
                while (left < right) {
                    int mid = (left + right) >> 1;
                    if (ids.get(mid) <= cur) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }
                if (right == ids.size() || cur >= ids.get(right)) {
                    flag = false;
                    break;
                }
                cur = ids.get(right);
            }
            if (flag) {
                ans++;
            }
        }
        return ans;
    }
}
