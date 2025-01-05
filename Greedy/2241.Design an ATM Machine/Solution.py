class ATM:

    def __init__(self):
        self.cnt = [0] * 5
        self.cash = [20, 50, 100, 200, 500]

    def deposit(self, banknotesCount: List[int]) -> None:
        for i in range(5):
            self.cnt[i] += banknotesCount[i]

    def withdraw(self, amount: int) -> List[int]:
        ans = [0] * 5
        for i in range(4, -1, -1):
            if amount >= self.cash[i]:
                cost = min(self.cnt[i], amount // self.cash[i])
                amount -= cost * self.cash[i]
                ans[i] = cost
        if amount == 0:
            for i in range(5):
                self.cnt[i] -= ans[i]
            return ans
        return [-1]



# Your ATM object will be instantiated and called as such:
# obj = ATM()
# obj.deposit(banknotesCount)
# param_2 = obj.withdraw(amount)