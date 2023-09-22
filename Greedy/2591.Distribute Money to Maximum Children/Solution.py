class Solution:
    def distMoney(self, money: int, children: int) -> int:
        if money < children:
            return -1
        money -= children
        i = 0
        while i < children and money >= 7:
            money -= 7
            i += 1
        if i < children - 1:
            return i
        if i == children - 1:
            return i if money != 3 else i - 1
        return i if money == 0 else i - 1