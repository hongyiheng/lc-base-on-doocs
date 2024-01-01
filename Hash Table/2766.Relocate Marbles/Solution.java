class Solution {
    public List<Integer> relocateMarbles(int[] nums, int[] moveFrom, int[] moveTo) {
        Set<Integer> ans = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        for (int i = 0; i < moveFrom.length; i++) {
            ans.remove(moveFrom[i]);
            ans.add(moveTo[i]);
        }
        return ans.stream().sorted((a, b) -> a - b).collect(Collectors.toList());
    }
}