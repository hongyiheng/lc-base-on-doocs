class Solution {
    public int[] addNegabinary(int[] arr1, int[] arr2) {
        if (arr1.length < arr2.length) {
            return addNegabinary(arr2, arr1);
        }
        int[] arr = new int[arr1.length + 3];
        int m = arr.length, n = arr2.length;
        for (int i = 3; i < m; i++) {
            arr[i] = arr1[i - 3];
        }
        Deque<Integer> ans = new ArrayDeque<>();
        int carry = 0;
        for (int i = 0; i < m; i++) {
            int v = arr[m - i - 1] + carry;
            carry = 0;
            v += i < n ? arr2[n - 1 - i] : 0;
            if (v >= 2) {
                v -= 2;
                carry = -1;
            }
            if (v == -1) {
                arr[m - i - 2]++;
                v = 1;
            }
            ans.addFirst(v);
        }
        while (ans.size() > 1 && ans.peekFirst() == 0) {
            ans.removeFirst();
        }
        int[] res = new int[ans.size()];
        int i = 0;
        while (!ans.isEmpty()) {
            res[i++] = ans.pollFirst();
        }
        return res;
    }
}
