class Solution {
    public String dayOfTheWeek(int day, int month, int year) {
        String[] dayOfWeek = new String[]{"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        int[] months = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
            months[1] += 1;
        }
        for (int i = 1971; i < year; i++) {
            day += ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) ? 366 : 365;
        }
        System.out.println(day);
        for (int i = 1; i < month; i++) {
            day += months[i - 1];
        }
        return dayOfWeek[(day + 4) % 7];
    }
}