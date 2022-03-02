class Solution {
    public boolean isStrobogrammatic(String num) {
        Map<Character, Character> mp = new HashMap<>();
        mp.put('6', '9');
        mp.put('9', '6');
        mp.put('8', '8');
        mp.put('1', '1');
        mp.put('0', '0');
        char[] chars = num.toCharArray();
        int l = 0, r = chars.length - 1;
        while (l <= r) {
            if (mp.getOrDefault(chars[l], 'a') != chars[r] || mp.getOrDefault(chars[r], 'b') != chars[l]) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}