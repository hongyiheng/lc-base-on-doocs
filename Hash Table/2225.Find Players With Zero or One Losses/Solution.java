class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, Integer> to = new HashMap<>();
        for (int[] e : matches) {
            int w = e[0], l = e[1];
            to.put(w, to.getOrDefault(w, 0));
            to.put(l, to.getOrDefault(l, 0) + 1);
        }
        List<Integer> win = new ArrayList<>(), loseOne = new ArrayList<>();
        for (Map.Entry<Integer, Integer> e : to.entrySet()) {
            if (e.getValue() == 0) {
                win.add(e.getKey());
            } else if (e.getValue() == 1) {
                loseOne.add(e.getKey());
            }
        }
        Collections.sort(win);
        Collections.sort(loseOne);
        return Arrays.asList(win, loseOne);
    }
}