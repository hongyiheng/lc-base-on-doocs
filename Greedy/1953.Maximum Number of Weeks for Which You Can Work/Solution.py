class Solution:
    def numberOfWeeks(self, milestones: List[int]) -> int:
        s = sum(milestones)
        mx = max(milestones)
        if s - mx >= mx - 1:
            return s
        return (s - mx) * 2 + 1