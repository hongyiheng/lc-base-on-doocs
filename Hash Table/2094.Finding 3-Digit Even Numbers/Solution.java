class Solution {
    public int[] findEvenNumbers(int[] digits) {
        int[] cnt = new int[10];
        for (int v : digits) {
            cnt[v]++;
        }
        List<Integer> even = new ArrayList<>();
        for (int i = 100; i < 1000; i++) {
            if (i % 2 == 0) {
                int[] tmp = new int[10];
                int cur = i;
                while (cur > 0) {
                    tmp[cur % 10]++;
                    cur /= 10;
                }
                boolean isEven = true;
                for (int j = 0; j < 10; j++) {
                    if (cnt[j] < tmp[j]) {
                        isEven = false;
                        break;
                    }
                }
                if (isEven) {
                    even.add(i);
                }
            }
        }
        int[] ans = new int[even.size()];
        for (int i = 0; i < even.size(); i++) {
            ans[i] = even.get(i);
        }
        return ans;
    }
}