class Solution:
    def maximizeSquareArea(self, m: int, n: int, hFences: List[int], vFences: List[int]) -> int:
        hFences = hFences + [1, m]
        vFences = vFences + [1, n]
        hs = set()
        for i in range(len(hFences)):
            for j in range(i + 1, len(hFences)):
                hs.add(abs(hFences[i] - hFences[j]))
        ans = -1
        for i in range(len(vFences)):
            for j in range(i + 1, len(vFences)):
                v = abs(vFences[i] - vFences[j])
                if v in hs:
                    ans = max(ans, v)
        return -1 if ans == -1 else ans * ans % int(1e9 + 7)