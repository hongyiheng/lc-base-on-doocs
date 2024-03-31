class Solution {
    public boolean isValidSerialization(String preorder) {
        int s = 1;
        for (String node : preorder.split(",")) {
            if (--s < 0) {
                return false;
            }
            if (!"#".equals(node)) {
                s += 2;
            }
        }
        return s == 0;
    }
}