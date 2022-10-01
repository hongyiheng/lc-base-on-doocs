class Solution:
    def reformatNumber(self, number: str) -> str:
        nums = deque()
        for c in number:
            if '0' <= c <= '9':
                nums.append(c)
        ans = []
        while len(nums) > 4:
            ans.append(nums.popleft() + nums.popleft() + nums.popleft())
        if nums:
            if len(nums) == 3:
                ans.append(nums.popleft() + nums.popleft() + nums.popleft())
            else:
                while nums:
                    ans.append(nums.popleft() + nums.popleft())
        return "-".join(ans)
