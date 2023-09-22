class Solution {
    public int distMoney(int money, int children) {
        if (money < children) {
            return -1;
        }
        money -= children;
        int i = 0;
        while (i < children && money >= 7) {
            money -= 7;
            i++;
        }
        if (i < children - 1) {
            return i;
        }
        if (i == children - 1) {
            return money == 3 ? i - 1 : i;
        }
        return money == 0 ? i : i - 1;
    }
}