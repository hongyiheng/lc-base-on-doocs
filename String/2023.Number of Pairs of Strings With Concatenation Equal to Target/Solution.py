class Solution:
    def numOfPairs(self, nums: List[str], target: str) -> int:
        n, ans = len(target), 0
        mp = {}
        for w in nums:
            mp[w] = mp.get(w, 0) + 1
        for i in range(n):
            pre, tail = target[:i], target[i:]
            pre_num = mp.get(pre, 0)
            if pre != tail:
                ans += pre_num * mp.get(tail, 0)
            else:
                ans += pre_num * (pre_num - 1)
        return ans