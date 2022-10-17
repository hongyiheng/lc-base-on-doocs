class Solution:
    def totalFruit(self, fruits: List[int]) -> int:
        l, r, n = 0, 0, len(fruits)
        ans = cur = 0
        mp = dict()
        while r < n:
            while r < n and (fruits[r] in mp or len(mp) < 2):
                mp[fruits[r]] = mp.get(fruits[r], 0) + 1
                cur += 1
                r += 1
            ans = max(ans, cur)
            while len(mp) == 2:
                mp[fruits[l]] -= 1
                if mp[fruits[l]] == 0:
                    mp.pop(fruits[l])
                cur -= 1
                l += 1
        return ans
