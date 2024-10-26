import java.math.BigInteger;

class Solution {
    public int maxTotalReward(int[] rewardValues) {
        int n = rewardValues.length;
        Arrays.sort(rewardValues);
        if (n > 1 && rewardValues[n - 2] == rewardValues[n - 1] - 1) {
            return 2 * rewardValues[n - 1] - 1;
        }
        int[] nums = Arrays.stream(rewardValues).distinct().toArray();
        BigInteger f = BigInteger.ONE;
        for (int v : nums) {
            BigInteger mask = BigInteger.ONE.shiftLeft(v).subtract(BigInteger.ONE);
            BigInteger shiftLeft = f.and(mask).shiftLeft(v);
            f = f.or(shiftLeft);
        }
        return f.bitLength() - 1;
    }
}