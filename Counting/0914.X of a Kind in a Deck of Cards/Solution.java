class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int k : deck) {
            int v = cnt.getOrDefault(k, 0) + 1;
            cnt.put(k, v);
        }
        int x = 0;
        for (int v : cnt.values()) {
            x = gcd(x, v);
            if (x == 1) {
                return false;
            }
        }
        return x >= 2;
    }

    public int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
