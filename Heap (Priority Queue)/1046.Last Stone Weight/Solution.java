class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> stk = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int stone : stones) {
            stk.offer(stone);
        }
        while (stk.size() > 1) {
            int y = stk.poll();
            int x = stk.poll();
            if (x != y) {
                stk.offer(y - x);
            }
        }
        return stk.isEmpty() ? 0 : stk.poll();
    }
}