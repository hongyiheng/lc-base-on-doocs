class Solution {
    public int[] prevPermOpt1(int[] arr) {
        Map<Integer, Integer> mp = new HashMap<>();
        int n = arr.length;
        for (int i = n - 1; i > -1; i--) {
            for (int j = arr[i] - 1; j > -1; j--) {
                if (mp.containsKey(j)) {
                    int tmp = arr[i];
                    arr[i] = arr[mp.get(j)];
                    arr[mp.get(j)] = tmp;
                    return arr;
                }
            }
            mp.put(arr[i], i);
        }
        return arr;
    }
}
