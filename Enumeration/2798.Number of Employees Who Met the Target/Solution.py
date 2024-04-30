class Solution:
    def numberOfEmployeesWhoMetTarget(self, hours: List[int], target: int) -> int:
        ans = 0
        for v in hours:
            if v >= target:
                ans += 1
        return ans