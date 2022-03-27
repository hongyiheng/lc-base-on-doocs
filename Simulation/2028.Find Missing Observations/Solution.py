class Solution:
    def missingRolls(self, rolls: List[int], mean: int, n: int) -> List[int]:
        m = len(rolls)
        target = (m + n) * mean
        for v in rolls:
            target -= v
        if target > 6 * n or target < n:
            return []
        avg_num = target // n
        other = target % n
        ans = [avg_num] * n
        for i in range(other):
            ans[i] += 1
        return ans