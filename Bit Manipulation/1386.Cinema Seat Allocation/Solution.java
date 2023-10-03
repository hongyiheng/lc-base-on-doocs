class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
      int M = (1 << 11) - 1;
      int L = 0, MID = 0, R = 0;
      for (int i = 2; i < 6; i++) {
          L |= 1 << i;
          MID |= 1 << (i + 2);
          R |= 1 << (i + 4);
      }
      Map<Integer, Integer> g = new HashMap<>();
      for (int[] e : reservedSeats) {
          g.put(e[0], g.getOrDefault(e[0], M) ^ (1 << e[1]));
      }
      int ans = 2 * n;
      for (int v : g.values()) {
          boolean l = (v & L) == L, mid = (v & MID) == MID, r = (v & R) == R;
          if (l && r) {
              continue;
          }
          if (l || mid || r) {
              ans--;
          } else {
              ans -= 2;
          }
      }
      return ans;
    }
}