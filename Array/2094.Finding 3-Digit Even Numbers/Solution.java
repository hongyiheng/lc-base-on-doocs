class Solution {
    public int[] findEvenNumbers(int[] digits) {
        Set<Integer> s = new HashSet<>();
        int n = digits.length;
        for (int i = 0; i < n; i++) {
            if (digits[i] == 0) {
                continue;
            }
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                for (int k = 0; k < n; k++) {
                    if (k == i || k == j || digits[k] % 2 == 1) {
                        continue;
                    }
                    s.add(digits[i] * 100 + digits[j] * 10 + digits[k]);
                }
            }
        }
        return s.stream().distinct().sorted().mapToInt(Integer::intValue).toArray();
    }
}