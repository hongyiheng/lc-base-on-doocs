class Solution {
    public String reformatNumber(String number) {
        Deque<String> nums = new ArrayDeque<>();
        for (char c : number.toCharArray()) {
            if (c >= '0' && c <= '9') {
                nums.addLast(String.valueOf(c));
            }
        }
        List<String> ans = new ArrayList<>();
        while (nums.size() > 4) {
            ans.add(nums.pollFirst() + nums.pollFirst() + nums.pollFirst());
        }
        if (!nums.isEmpty()) {
            if (nums.size() == 3) {
                ans.add(nums.pollFirst() + nums.pollFirst() + nums.pollFirst());
            } else {
                while (!nums.isEmpty()) {
                    ans.add(nums.pollFirst() + nums.pollFirst());
                }
            }
        }
        return String.join("-", ans);
    }
}
