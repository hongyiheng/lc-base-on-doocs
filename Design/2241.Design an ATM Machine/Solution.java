class ATM {

    long[] cash, cnt;

    public ATM() {
        cash = new long[]{20, 50, 100, 200, 500};
        cnt = new long[5];
    }

    public void deposit(int[] banknotesCount) {
        for (int i = 0; i < 5; i++) {
            cnt[i] += banknotesCount[i];
        }
    }

    public int[] withdraw(int amount) {
        int[] ans = new int[5];
        for (int i = 4; i > -1; i--) {
            if (amount >= cash[i]) {
                long cost = Math.min(cnt[i], amount / cash[i]);
                amount -= cost * cash[i];
                ans[i] = (int)cost;
            }
        }
        if (amount > 0) {
            return new int[]{-1};
        }
        for (int i = 0; i < 5; i++) {
            cnt[i] -= ans[i];
        }
        return ans;
    }
}

/**
 * Your ATM object will be instantiated and called as such:
 * ATM obj = new ATM();
 * obj.deposit(banknotesCount);
 * int[] param_2 = obj.withdraw(amount);
 */
