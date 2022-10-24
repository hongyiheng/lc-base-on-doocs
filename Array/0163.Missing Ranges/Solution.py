class Solution:
    def findMissingRanges(self, nums: List[int], lower: int, upper: int) -> List[str]:
        def get_str(a, b):
            if b - a <= 1:
                return None
            if b - a == 2:
                return str(a + 1)
            return str(a + 1) + "->" + str(b - 1)

        ans = []
        n, last = len(nums), lower - 1
        if n == 0:
            s = get_str(lower - 1, upper + 1)
            if s:
                ans.append(s)
            return ans
        for i in range(n):
            s = get_str(last, nums[i])
            if s:
                ans.append(s)
            last = nums[i]
        s = get_str(last, upper + 1)
        if s:
            ans.append(get_str(last, upper + 1))
        return ans
