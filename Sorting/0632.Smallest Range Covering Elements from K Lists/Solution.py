class Solution:
    def smallestRange(self, nums: List[List[int]]) -> List[int]:
        q = []
        for i, arr in enumerate(nums):
            for v in arr:
                q.append((v, i))
        q.sort(key=lambda x: x[0])
        cnt = defaultdict(int)
        ans = [q[0][0], q[-1][0]]
        l = r = 0
        while r < len(q):
            cnt[q[r][1]] += 1
            while len(cnt) == len(nums):
                if ans[1] - ans[0] > q[r][0] - q[l][0]:
                    ans = [q[l][0], q[r][0]]
                cnt[q[l][1]] -= 1
                if cnt[q[l][1]] == 0:
                    cnt.pop(q[l][1])
                l += 1
            r += 1
        return ans
