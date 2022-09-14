class Solution {
    public int calculate(String s) {
        char[] cs = s.toCharArray();
        Deque<Integer> nums = new ArrayDeque<>();
        Deque<Character> cals = new ArrayDeque<>();
        int idx = 0, n = cs.length;
        while (idx < n) {
            if (cs[idx] == ' ') {
                idx++;
                continue;
            } else if ('0' <= cs[idx] && cs[idx] <= '9') {
                int num = 0;
                while (idx < n && '0' <= cs[idx] && cs[idx] <= '9') {
                    num = num * 10 + cs[idx] - '0';
                    idx++;
                }
                nums.addLast(num);
                if (!cals.isEmpty() && (cals.peekLast() == '*' || cals.peekLast() == '/')) {
                    int b = nums.pollLast(), a = nums.pollLast();
                    nums.addLast(calNum(a, b, cals.pollLast()));
                }
                continue;
            } else {
                cals.addLast(cs[idx]);
            }
            idx++;
        }
        while (!cals.isEmpty()) {
            nums.addFirst(calNum(nums.pollFirst(), nums.pollFirst(), cals.pollFirst()));
        }
        return nums.pollLast();
    }

    public int calNum(int a, int b, Character cal) {
        if (cal == '*') {
            return a * b;
        } else if (cal == '/') {
            return a / b;
        } else if (cal == '+') {
            return a + b;
        }
        return a - b;
    }
}