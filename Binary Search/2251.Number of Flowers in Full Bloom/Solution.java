class Solution {

    public int lowerBound(int[] arr, int x) {
        int l = 0, r = arr.length - 1;
        while (l < r) {
            int mid = (l + r + 1) >> 1;
            if (arr[mid] <= x) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return arr[r] <= x ? r + 1 : r;
    }


    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        int n = flowers.length, m = people.length;
        int[] start = new int[n], end = new int[n];
        for (int i = 0; i < n; i++) {
            start[i] = flowers[i][0];
            end[i] = flowers[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int[] ans = new int[m];
        for (int i = 0; i < m; i++) {
            ans[i] = lowerBound(start, people[i]) - lowerBound(end, people[i] - 1);
        }
        return ans;
    }
}