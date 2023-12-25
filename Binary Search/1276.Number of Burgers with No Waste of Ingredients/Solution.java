class Solution {
    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        int l = 0, r = cheeseSlices;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (mid * 4 + (cheeseSlices - mid) * 2 < tomatoSlices) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return r * 4 + (cheeseSlices - r) * 2 == tomatoSlices ? Arrays.asList(r, cheeseSlices - r) : Collections.emptyList();
    }
}