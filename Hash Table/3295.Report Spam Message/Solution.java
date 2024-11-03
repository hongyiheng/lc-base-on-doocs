class Solution {
    public boolean reportSpam(String[] message, String[] bannedWords) {
        Set<String> bans = new HashSet<>(Arrays.asList(bannedWords));
        int cnt = 0;
        for (String s : message) {
            if (bans.contains(s)) {
                cnt++;
            }
        }
        return cnt >= 2;
    }
}