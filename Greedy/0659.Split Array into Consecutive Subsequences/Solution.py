class Solution:
    def isPossible(self, nums: List[int]) -> bool:
        cnt, tail = defaultdict(int), defaultdict(int)
        for v in nums:
            cnt[v] += 1
        for i in range(-1000, 1000):
            while cnt[i]:
                if tail[i - 1]:
                    tail[i - 1] -= 1
                    tail[i] += 1
                    cnt[i] -= 1
                elif cnt[i + 1] and cnt[i + 2]:
                    cnt[i] -= 1
                    cnt[i + 1] -= 1
                    cnt[i + 2] -= 1
                    tail[i + 2] += 1
                else:
                    return False
        return True