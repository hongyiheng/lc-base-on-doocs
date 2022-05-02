class Solution {
    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        List<Integer> ans = new ArrayList<>();
        int idx1 = 0, idx2 = 0, idx3 = 0;
        int n1 = arr1.length, n2 = arr2.length, n3 = arr3.length;
        while (idx1 < n1 && idx2 < n2 && idx3 < n3) {
            int val1 = arr1[idx1], val2 = arr2[idx2], val3 = arr3[idx3];
            if (val1 == val2 && val2 == val3) {
                ans.add(val1);
                idx1++;
                idx2++;
                idx3++;
            }
            if (val1 < val2 || val1 < val3) {
                idx1++;
            }
            if (val2 < val1 || val2 < val3) {
                idx2++;
            }
            if (val3 < val1 || val3 < val2) {
                idx3++;
            }
        }
        return ans;
    }
}