class Solution {
    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        List<int[]> res = new ArrayList<>();
        for (int[] v : restaurants) {
            if (veganFriendly == 1 && v[2] == 0) {
                continue;
            }
            if (v[3] > maxPrice || v[4] > maxDistance) {
                continue;
            }
            res.add(v);
        }
        return res.stream()
                .sorted((a, b) -> a[1] != b[1] ? b[1] - a[1] : b[0] - a[0])
                .map(e -> e[0])
                .collect(Collectors.toList());
    }
}