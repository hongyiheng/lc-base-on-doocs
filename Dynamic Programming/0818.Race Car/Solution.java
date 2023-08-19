class Solution {
    public int racecar(int target) {
        int[] f = new int[target + 1];
        Arrays.fill(f, 0x3f3f3f3f);
        for (int i = 1; i < target + 1; i++) {
            int d = 1;
            while ((1 << d) - 1 < 2 * i) {
                int forward = (1 << d) - 1;
                if (forward == i) {
                    f[i] = d;
                } else if (forward > i) {
                    f[i] = Math.min(f[i], d + 1 + f[forward - i]);
                } else {
                    f[i] = Math.min(f[i], d + 2 + f[i - forward]);
                    int b = 1;
                    while ((1 << b) - 1 < forward) {
                        int backward = (1 << b) - 1;
                        f[i] = Math.min(f[i], d + 1 + b + 1 + f[i - forward + backward]);
                        b++;
                    }
                }
                d++;
            }
        }
        return f[target];
    }
}