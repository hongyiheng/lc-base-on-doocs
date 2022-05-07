class Solution {
    public int minMutation(String start, String end, String[] bank) {
        char[] dirs = new char[]{'A', 'C', 'G', 'T'};
        Set<String> bankSet = Stream.of(bank).collect(Collectors.toSet());
        Deque<String> q = new ArrayDeque<>();
        int step = 0;
        q.addLast(start);
        while (!q.isEmpty()) {
            int m = q.size();
            for (int k = 0; k < m; k++) {
                String cur = q.pollFirst();
                char[] chars = cur.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    for (char d : dirs) {
                        if (chars[i] != d) {
                            chars[i] = d;
                            String nx = new String(chars);
                            if (bankSet.contains(nx)) {
                                if (nx.equals(end)) {
                                    return step + 1;
                                }
                                bankSet.remove(nx);
                                q.addLast(nx);
                            }
                        }
                    }
                }
            }
            step++;
        }
        return -1;
    }
}