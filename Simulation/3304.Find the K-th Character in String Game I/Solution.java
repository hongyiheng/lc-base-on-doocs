class Solution {
    public char kthCharacter(int k) {
        List<Integer> q = new ArrayList<>();
        q.add(0);
        while (q.size() < k) {
            List<Integer> nq = new ArrayList<>();
            for (int v : q) {
                nq.add(v + 1);
            }
            q.addAll(nq);
        }
        return (char)(q.get(k - 1) % 26 + 'a');
    }
}