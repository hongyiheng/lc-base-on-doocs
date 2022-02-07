from sortedcontainers import SortedList

class Solution:
    def longestDiverseString(self, a: int, b: int, c: int) -> str:
        q = SortedList(key=lambda x: x[1])
        if a > 0:
            q.add([0, a])
        if b > 0:
            q.add([1, b])
        if c > 0:
            q.add([2, c])
        ans = ""
        while q:
            cur = q.pop()
            n = len(ans)
            if n >= 2 and ord(ans[n - 1]) - ord('a') == cur[0] and ord(ans[n - 2]) - ord('a') == cur[0]:
                if q:
                    nx = q.pop()
                    ans += chr(nx[0] + ord('a'))
                    nx[1] -= 1
                    if nx[1] > 0:
                        q.add(nx)
                    q.add(cur)
            else:
                ans += chr(cur[0] + ord('a'))
                cur[1] -= 1
                if cur[1] > 0:
                    q.add(cur)
        return ans
