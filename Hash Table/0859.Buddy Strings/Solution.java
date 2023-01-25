class Solution {
    public boolean buddyStrings(String s, String goal) {
        int n = s.length();
        if (n != goal.length()) {
            return false;
        }
        Set<Character> ss = new HashSet();
        List<char[]> diff = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ss.add(s.charAt(i));
            if (s.charAt(i) != goal.charAt(i)) {
                diff.add(new char[]{s.charAt(i), goal.charAt(i)});
            }
        }
        if (s.equals(goal) && ss.size() != n) {
            return true;
        }
        return diff.size() == 2 && diff.get(0)[0] == diff.get(1)[1] && diff.get(0)[1] == diff.get(1)[0];
    }
}