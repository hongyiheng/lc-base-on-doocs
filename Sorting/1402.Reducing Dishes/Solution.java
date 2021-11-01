class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int right = 1;
        int positive = 0;
        int positiveSum = 0;
        int positiveIndex = 0;
        for (int num : satisfaction) {
            if (num >= 0) {
                positive += num * right++;
                positiveSum += num;
            } else {
                positiveIndex++;
            }
        }

        int[] negativeArray = new int[positiveIndex];
        int index = 0;
        for (int i = positiveIndex - 1; i >= 0; i--) {
            int negative = satisfaction[i];
            int dup = positiveIndex - i;
            for (int j = positiveIndex - 1; j > i; j--) {
                negative += dup * satisfaction[j];
                dup--;
            }
            negativeArray[index++] = negative;
        }

        int res = positive;
        int dup = 1;
        for (int value : negativeArray) {
            res = Math.max(res, positive + (positiveSum * dup++) + value);
        }
        return res;
    }
}