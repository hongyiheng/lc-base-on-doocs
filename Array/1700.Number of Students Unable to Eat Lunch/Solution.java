class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int a = 0, b = 0;
        for (int v : students) {
            if (v == 0) {
                a++;
            } else {
                b++;
            }
        }
        for (int v : sandwiches) {
            if (v == 0) {
                if (a > 0) {
                    a--;
                } else {
                    break;
                }
            }
            if (v == 1) {
                if (b > 0) {
                    b--;
                } else {
                    break;
                }
            }
        }
        return a + b;
    }
}
