class Solution {
    public int checkWays(int[][] pairs) {
        Map<Integer, Set<Integer>> mp = new HashMap<>();
        for (int[] p : pairs) {
            mp.computeIfAbsent(p[0], k -> new HashSet<>()).add(p[1]);
            mp.computeIfAbsent(p[1], k -> new HashSet<>()).add(p[0]);
        }
        int rootCnt = -1, rootVal = -1;
        for (int a : mp.keySet()) {
            mp.get(a).add(a);
            if (mp.get(a).size() > rootCnt) {
                rootCnt = mp.get(a).size();
                rootVal = a;
            }
        }
        if (rootCnt != mp.size()) {
            return 0;
        }
        int ans = 1;
        for (int son : mp.keySet()) {
            if (son == rootVal) {
                continue;
            }
            int sonCnt = mp.get(son).size();
            int parentCnt = Integer.MAX_VALUE;
            int parentVal = -1;
            for (int p : mp.get(son)) {
                if (p != son && mp.get(p).size() >= sonCnt && mp.get(p).size() < parentCnt) {
                    parentCnt = mp.get(p).size();
                    parentVal = p;
                }
            }
            if (parentVal == -1 || !mp.get(parentVal).containsAll(mp.get(son))) {
                return 0;
            }
            if (parentCnt == sonCnt) {
                ans = 2;
            }
        }
        return ans;
    }
}