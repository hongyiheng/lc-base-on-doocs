class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int left = 0, right = people.length - 1;
        int ans = 1;
        int cur = limit, num = 2;
        while (left <= right) {
            num--;
            if (num >= 0 && cur >= people[right]) {
                cur -= people[right--];
            } else if (num >= 0 && cur >= people[left]) {
                cur -= people[left++];
            } else {
                cur = limit;
                num = 2;
                ans++;
            }
        }
        return ans;
    }
}