class Solution:
    def canReorderDoubled(self, arr: List[int]) -> bool:
        n, m = 100010, 2 * 100010
        cnt = [0] * 2 * m
        nums = []
        for v in arr:
            cnt[v + n] += 1
            if cnt[v + n] == 1:
                nums.append(v)
        nums.sort(key=lambda x: abs(x))
        for v in nums:
            if cnt[v + n] > cnt[2 * v + n]:
                return False
            cnt[2 * v + n] -= cnt[v + n]
        return True