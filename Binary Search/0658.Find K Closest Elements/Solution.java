class Solution {
    int x;

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length;
        this.x = x;
        List<Integer> ans = new ArrayList<>();
        if (n <= k) {
            for (int num : arr) {
                ans.add(num);
            }
            return ans;
        }
        int left = 0, right = n - 1;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (arr[mid] < x) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (left > 0 && check(arr[left - 1], arr[left])) {
            left = left - 1;
        }
        int a = left, b = left;
        while (--k > 0) {
            if (a > 0 && b < n - 1) {
                if (check(arr[--a], arr[++b])) {
                    --b;
                } else {
                    ++a;
                }
            } else if (a > 0) {
                --a;
            } else {
                ++b;
            }
        }
        for (int i = a; i <= b; i++) {
            ans.add(arr[i]);
        }
        return ans;
    }


    public boolean check(int a, int b) {
        return Math.abs(a - x) < Math.abs(b - x)
                || (Math.abs(a - x) == Math.abs(b - x) && a < b);
    }
}