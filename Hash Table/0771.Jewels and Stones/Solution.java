class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        int res = 0;
        Set<Character> jewelSet = new HashSet<>();
        for(char item : jewels.toCharArray()){
            jewelSet.add(item);
        }
        char[] stoneArray = stones.toCharArray();
        for (char item : stoneArray) {
            if (jewelSet.contains(item)) {
                res++;
            }
        }
        return res;
    }
}