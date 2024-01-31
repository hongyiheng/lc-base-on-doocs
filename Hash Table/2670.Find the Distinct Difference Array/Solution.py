class Solution:
    def distinctDifferenceArray(self, nums: List[int]) -> List[int]:
        cnt = defaultdict(int)
        for v in nums:
            cnt[v] += 1
        ans = []
        s = set()
        for v in nums:
            s.add(v)
            cnt[v] -= 1
            if cnt[v] == 0:
                cnt.pop(v)
            ans.append(len(s) - len(cnt.keys()))
        return ans