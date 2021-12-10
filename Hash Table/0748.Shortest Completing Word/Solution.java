class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] mp = new int[26];
        for (char c : licensePlate.toLowerCase().toCharArray()) {
            if (c - 'a' >= 0 && c - 'a' < 26) {
                mp[c - 'a'] += 1;
            }
        }
        int minLen = Integer.MAX_VALUE;
        String ans = null;
        for (String word : words) {
            if (word.length() >= minLen) {
                continue;
            }
            int[] temp = mp.clone();
            boolean flag = true;
            for (int i = 0; i < word.length(); i++) {
                int index = word.charAt(i) - 'a';
                temp[index]--;
            }
            for (int num : temp) {
                if (num > 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                ans = word;
                minLen = word.length();
            }
        }
        return ans;
    }
}