class Solution:
    def largestNumber(self, nums: List[int]) -> str:
        def cmp(a, b):
            a_, b_ = str(a), str(b)
            return 1 if b_ + a_ > a_ + b_ else -1

        nums.sort(key=cmp_to_key(cmp))
        ans = ""
        for v in nums:
            ans += str(v)
        while len(ans) > 1 and ans[0] == "0":
            ans = ans[1:]
        return ans