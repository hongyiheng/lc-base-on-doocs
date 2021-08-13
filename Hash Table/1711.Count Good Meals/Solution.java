class Solution {
    public int countPairs(int[] deliciousness) {
        int mod = (int) (1e9 + 7);
        int maxNum = 0;
        for (int num : deliciousness){
            maxNum = Math.max(maxNum, num);
        }
        // 两数相加 最大值为数组中最大值*2
        int maxVal = maxNum * 2;
        long res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < deliciousness.length; i++) {
            // 遍历小于最大值的 2的所有幂次方
            for (int sum = 1; sum <= maxVal; sum *= 2) {
                // 存在和当前数相补成 2的幂次方的数时，加上该数在数组中出现在i左边的次数
                if (map.containsKey(sum - deliciousness[i])) {
                    res += map.get(sum - deliciousness[i]);
                }
            }
            map.put(deliciousness[i], map.getOrDefault(deliciousness[i], 0) + 1);
        }
        return (int) (res % mod);
    }
}