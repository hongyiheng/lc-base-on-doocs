class Solution:
    def lexicalOrder(self, n: int) -> List[int]:
        ans = []
        cur = 1
        while len(ans) < n:
            while cur <= n:
                ans.append(cur)
                cur *= 10
            while cur % 10 == 9 or cur > n:
                cur //= 10
            cur += 1
        return ans