class Solution:
    def numberOfArrays(self, differences: List[int], lower: int, upper: int) -> int:
        n = len(differences)
        last_hidden = min_val = max_val = lower
        for i in range(1, n + 1):
            last_hidden = last_hidden + differences[i - 1]
            max_val = max(max_val, last_hidden)
            min_val = min(min_val, last_hidden)
        ans = 0
        for _ in range(lower, upper + 1):
            if lower <= min_val and max_val <= upper:
                ans += 1
            min_val += 1
            max_val += 1
        return ans