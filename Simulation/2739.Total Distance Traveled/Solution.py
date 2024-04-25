class Solution:
    def distanceTraveled(self, mainTank: int, additionalTank: int) -> int:
        ans = cnt = 0
        while mainTank:
            ans += mainTank * 10
            cnt += mainTank
            extra = min(additionalTank, cnt // 5)
            cnt %= 5
            additionalTank -= extra
            mainTank = extra
        return ans