class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        Set<Integer> used = new HashSet<>();
        for (int v : fruits) {
            for (int i = 0; i < baskets.length; i++) {
                if (!used.contains(i) && baskets[i] >= v) {
                    used.add(i);
                    break;
                }
            }
        }
        return fruits.length - used.size();
    }
}