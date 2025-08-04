class Solution:
    def totalFruit(self, fruits: List[int]) -> int:
        l = r = ans = 0
        cnt = defaultdict(int)
        while r < len(fruits):
            cnt[fruits[r]] += 1
            while len(cnt.keys()) > 2:
                cnt[fruits[l]] -= 1
                if cnt[fruits[l]] == 0:
                    cnt.pop(fruits[l])
                l += 1
            ans = max(ans, r - l + 1)
            r += 1
        return ans
