class Solution:
    def convertTime(self, current: str, correct: str) -> int:
        cur = int(current.split(":")[0]) * 60 + int(current.split(":")[1])
        target = int(correct.split(":")[0]) * 60 + int(correct.split(":")[1])
        ans = 0
        while cur < target:
            diff = target - cur
            if diff >= 60:
                cur += 60
            elif diff >= 15:
                cur += 15
            elif diff >= 5:
                cur += 5
            else:
                cur += 1
            ans += 1
        return ans