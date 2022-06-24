class Solution:
    def earliestFullBloom(self, plantTime: List[int], growTime: List[int]) -> int:
        n = len(plantTime)
        q = [(plantTime[i], growTime[i]) for i in range(n)]
        q.sort(key=lambda x:x[1])
        idx = ans = 0
        while q:
            cur = q.pop()
            idx += cur[0]
            ans = max(idx + cur[1], ans)
        return ans