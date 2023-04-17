class Solution {
    public int getDay(String s) {
        int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int month = Integer.parseInt(s.split("-")[0]) - 1, day = Integer.parseInt(s.split("-")[1]);
        for (int i = 0; i < month; i++) {
            day += days[i];
        }
        return day;
    }

    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int a = getDay(arriveAlice), b = getDay(leaveAlice), c = getDay(arriveBob), d = getDay(leaveBob);
        if (d < a || b < c) {
            return 0;
        }
        return Math.min(b, d) - Math.max(a, c) + 1;
    }
}
