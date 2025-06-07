class Solution {
    public String clearStars(String s) {
        Map<Integer, Deque<Integer>> cnt = new HashMap<>();
        Set<Integer> exl = new HashSet<>();
        int d = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c == '*') {
                exl.add(i);
                d++;
            } else {
                int x = c - 'a';
                cnt.computeIfAbsent(x, k -> new ArrayDeque()).add(i);
            }
            if (d > 0) {
                for (int j = 0; j < 26; j++) {
                    if (!cnt.getOrDefault(j, new ArrayDeque()).isEmpty()) {
                        exl.add(cnt.get(j).pollLast());
                        break;
                    }
                }
                d--;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (!exl.contains(i)) {
                sb.append(chars[i]);
            }
        }
        return sb.toString();
    }
}