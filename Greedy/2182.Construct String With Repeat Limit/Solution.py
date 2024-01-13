class Solution:
    def repeatLimitedString(self, s: str, repeatLimit: int) -> str:
        cnt = [0] * 26
        for c in s:
            cnt[ord(c) - ord('a')] += 1
        ans, q = [], []
        for i, v in enumerate(cnt):
            if not v:
                continue
            heapq.heappush(q, (-i, v))
        while q:
            i, v = heapq.heappop(q)
            if ans and ans[-1] == i:
                if not q:
                    break
                ni, nv = heapq.heappop(q)
                ans.append(ni)
                if nv > 1:
                    heapq.heappush(q, (ni, nv - 1))
                heapq.heappush(q, (i, v))
            else:
                t = min(v, repeatLimit)
                ans.extend([i] * t)
                if v > t:
                    heapq.heappush(q, (i, v - t))
        return "".join([chr(-v + ord('a')) for v in ans])
