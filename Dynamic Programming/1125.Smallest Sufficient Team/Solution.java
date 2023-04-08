class Solution {
    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        int n = people.size(), m = req_skills.length;
        Map<String, Integer> sid = new HashMap<>();
        for (int i = 0; i < m; i++) {
            sid.put(req_skills[i], i);
        }
        int[] mask = new int[n];
        for (int i = 0; i < n; i++) {
            for (String s : people.get(i)) {
                mask[i] |= 1 << sid.get(s);
            }
        }
        long[] f = new long[1 << m];
        Arrays.fill(f, (1L << n) - 1);
        f[0] = 0;
        for (int i = 0; i < (1 << m) - 1; i++) {
            if (f[i] == (1 << n) - 1) {
                continue;
            }
            for (int j = 0; j < n; j++) {
                if (Long.bitCount(f[i]) + 1 < Long.bitCount(f[i | mask[j]])) {
                    f[i | mask[j]] = f[i] | (1L << j);
                }
            }
        }
        long ans = f[(1 << m) - 1];
        List<Integer> tmp = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if ((ans >> i & 1) == 1) {
                tmp.add(i);
            }
        }
        return tmp.stream().mapToInt(Integer::valueOf).toArray();
    }
}