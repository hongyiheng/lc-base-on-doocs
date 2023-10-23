class Solution:
    def countSeniors(self, details: List[str]) -> int:
        ans = 0
        for v in details:
            if int(v[11:13]) > 60:
                ans += 1
        return ans