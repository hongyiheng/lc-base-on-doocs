class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> q = new ArrayDeque<>();
        for (int v : asteroids) {
            if (v > 0) {
                q.addLast(v);
            } else {
                boolean exist = true;
                while (!q.isEmpty() && exist) {
                    if (q.peekLast() < 0) {
                        break;
                    }
                    if (q.peekLast() > Math.abs(v)) {
                        exist = false;
                    } else if (q.peekLast() == Math.abs(v)) {
                        exist = false;
                        q.pollLast();
                    } else {
                        q.pollLast();
                    }
                }
                if (exist) {
                    q.addLast(v);
                }
            }
        }
        int[] ans = new int[q.size()];
        int idx = 0;
        while (!q.isEmpty()) {
            ans[idx++] = q.pollFirst();
        }
        return ans;
    }
}