class Solution {
    public int numberOfWeakCharacters(int[][] properties) {
        Arrays.sort(properties, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]);
        int ans = 0, maxDefense = -1;
        for (int i = 0; i < properties.length; i++) {
            if (maxDefense > properties[i][1]) {
                ans++;
            } else {
                maxDefense = properties[i][1];
            }
        }
        return ans;
    }
}