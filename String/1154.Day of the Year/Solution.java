class Solution {
    public int dayOfYear(String date) {
        int[] months = new int[]{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] strs = date.split("-");
        int year = Integer.parseInt(strs[0]), month = Integer.parseInt(strs[1]), day = Integer.parseInt(strs[2]);
        if (year % 4 == 0) {
            months[2]++;
        }
        int ans = 0;
        while (--month > 0) {
            ans += months[month];
        }
        return ans + day;
    }
}