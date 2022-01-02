class Solution:
    def getFactors(self, n: int) -> List[List[int]]:
        nums, path, res = [], [], []
        for i in range(2, n // 2 + 1):
            if n % i == 0:
                nums.append(i)

        def back_trace(cur, index):
            if cur == 1:
                res.append(path[:])
                return
            for i in range(index, len(nums)):
                if cur % nums[i] == 0:
                    path.append(nums[i])
                    back_trace(cur // nums[i], i)
                    path.pop()

        if nums:
            back_trace(n, 0)
        return res