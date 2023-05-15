class Solution:
    def smallestRange(self, nums: List[List[int]]) -> List[int]:
        q = []
        for i, row in enumerate(nums):
            for v in row:
                q.append((v, i))
        q.sort()
        cnt = dict()
        l = r = 0
        ans = [q[0][0], q[-1][0]]
        while r < len(q):
            cnt[q[r][1]] = cnt.get(q[r][1], 0) + 1
            while len(cnt) == len(nums):
                if ans[1] - ans[0] > q[r][0] - q[l][0]:
                    ans = [q[l][0], q[r][0]]
                cnt[q[l][1]] -= 1
                if cnt[q[l][1]] == 0:
                    cnt.pop(q[l][1])
                l += 1
            r += 1
        return ans
