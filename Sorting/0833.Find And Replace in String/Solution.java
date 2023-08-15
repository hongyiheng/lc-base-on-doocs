class Solution {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        int k = indices.length;
        List<int[]> q = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            int l = indices[i], r = l + sources[i].length();
            if (r <= s.length() && s.substring(l, r).equals(sources[i])) {
                q.add(new int[]{indices[i], i});
            }
        }
        q.sort(Comparator.comparingInt(a -> -a[0]));
        for (int i = 0; i < q.size(); i++) {
            int idx = q.get(i)[1];
            int l = indices[idx], r = l + sources[idx].length();
            s = s.substring(0, l) + targets[idx] + s.substring(r);
        }
        return s;
    }
}