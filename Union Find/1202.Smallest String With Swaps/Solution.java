class Solution {

    int[] p;

    public int find(int x) {
        if (p[x] != x) {
            p[x] = find(p[x]);
        }
        return p[x];
    }

    public void union(int a, int b) {
        p[find(a)] = find(b);
    }

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int n = s.length();
        p = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = i;
        }
        for (List<Integer> pair : pairs) {
            union(pair.get(0), pair.get(1));
        }
        Map<Integer, int[]> g = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int f = find(i);
            if (!g.containsKey(f)) {
                g.put(f, new int[26]);
            }
            g.get(f)[s.charAt(i) - 'a']++;
        }
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int f = find(i);
            for (int j = 0; j < 26; j++) {
                if (g.get(f)[j] > 0) {
                    ans.append((char) (j + 'a'));
                    g.get(f)[j]--;
                    break;
                }
            }
        }
        return ans.toString();
    }
}
