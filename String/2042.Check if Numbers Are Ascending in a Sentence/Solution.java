class Solution {
    public boolean areNumbersAscending(String s) {
        int last = -1;
        for (String w : s.split(" ")) {
            if (w.charAt(0) >= '0' && w.charAt(0) <= '9') {
                int cur = Integer.parseInt(w);
                if (cur <= last) {
                    return false;
                }
                last = cur;
            }
        }
        return true;
    }
}