class Solution {
    public int distributeCandies(int[] candyType) {
        int m = candyType.length;
        int n = m / 2;
        Set<Integer> type = new HashSet<>();
        for (int candy : candyType) {
            type.add(candy);
        }
        return type.size() > n ? n : type.size();
    }
}