class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        s = set()
        for num in nums:
            s.add(num)
        ans = 0
        for num in s:
            left, right = num, num
            if (left - 1) not in s:
                while (right + 1) in s:
                    right += 1
            ans = max(ans, right - left + 1)
        return ans