class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        int x = 0, y = 0, d = 1;
        long ans = 0;
        Set<String> s = new HashSet<>();
        for (int[] v : obstacles) {
            s.add(v[0] + "-" + v[1]);
        }
        for (int c : commands) {
            if (c < 0) {
                if (c == -2) {
                    d--;
                } else if (c == -1) {
                    d++;
                }
                d = (d + 4) % 4;
            } else {
                while (c > 0) {
                    if (d == 1) {
                        if (s.contains(x + "-" + (y + 1))) {
                            break;
                        }
                        y++;
                    } else if (d == 3) {
                        if (s.contains(x + "-" + (y - 1))) {
                            break;
                        }
                        y--;
                    } else if (d == 0) {
                        if (s.contains((x - 1) + "-" + y)) {
                            break;
                        }
                        x--;
                    } else {
                        if (s.contains((x + 1) + "-" + y)) {
                            break;
                        }
                        x++;
                    }
                    c--;
                }
                ans = Math.max(ans, 1L * x * x + 1L * y * y);
            }
        }
        return (int)ans;
    }
}
