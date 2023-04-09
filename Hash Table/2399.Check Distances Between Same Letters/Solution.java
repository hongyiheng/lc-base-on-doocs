class Solution {
    public boolean checkDistances(String s, int[] distance) {
        int[] ids = new int[26];
        Arrays.fill(ids, -1);
        for (int i = 0; i < s.length(); i++) {
            int id = s.charAt(i) - 'a';
            if (ids[id] == -1) {
                ids[id] = i;
            } else {
                int gap = i - ids[id] - 1;
                if (gap != distance[id]) {
                    return false;
                }
            }
        }
        return true;
    }
}