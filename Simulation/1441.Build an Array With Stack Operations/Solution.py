class Solution:
    def buildArray(self, target: List[int], n: int) -> List[str]:
        ans = []
        idx, m = 0, len(target)
        for i in range(1, n + 1):
            if idx == m:
                break
            if target[idx] != i:
                ans.append("Push")
                ans.append("Pop")
            else:
                idx += 1
                ans.append("Push")
        return ans
